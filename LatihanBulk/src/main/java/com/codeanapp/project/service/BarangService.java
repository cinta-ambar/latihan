package com.codeanapp.project.service;

import com.codeanapp.project.mapper.BarangMapper;
import com.codeanapp.project.model.Barang;
import com.codeanapp.project.model.response.DataResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.util.AppUtil;
import com.codeanapp.project.util.LoggingHolder;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BarangService {
    private final BarangMapper barangMapper;
    private final SqlSessionTemplate batchSqlSessionTemplate;
    private static final int MAX_BATCH_SIZE = 1000;
    private static final String SUCCESS = "Success";
    private final LoggingHolder loggingHolder;

    public BarangService(BarangMapper barangMapper, SqlSessionTemplate batchSqlSessionTemplate, LoggingHolder loggingHolder) {
        this.barangMapper = barangMapper;
        this.batchSqlSessionTemplate = batchSqlSessionTemplate;
        this.loggingHolder = loggingHolder;
    }

    @Transactional
    public DataResponse<List<Barang>> bulkInsertBarang(List<Barang> barangList) {
        DataResponse<List<Barang>> response = new DataResponse<>();
        try {
            log.info("bulkInsertBarang called with {} items", barangList.size());

            if (barangList == null || barangList.isEmpty()) {
                return new DataResponse<>(
                        "failed",
                        "no data",
                        loggingHolder.getPath(),
                        loggingHolder.getDate(),
                        HttpStatus.BAD_REQUEST.value(),
                        loggingHolder.getVersion(),
                        null
                );
            }
            for (int i = 0; i < barangList.size(); i++) {
                Barang b = barangList.get(i);
                log.info("Item {}: idHeader={}, namaBarang={}, kodeBarang={}, seriBarang={}",
                        i, b.getIdHeader(), b.getNamaBarang(), b.getKodeBarang(), b.getSeriBarang());

                if (b.getIdBarang() == null || b.getIdBarang().trim().isEmpty()) {
                    b.setIdBarang(UUID.randomUUID().toString());
                }
                if (b.getWaktuRekam() == null) {
                    b.setWaktuRekam(new Timestamp(System.currentTimeMillis()));
                }
            }

            List<List<Barang>> chunks = AppUtil.splitList(barangList, MAX_BATCH_SIZE);

            int chunkIndex = 0;
            for (List<Barang> chunk : chunks) {
                chunkIndex++;
                try {
                    barangMapper.bulkInsertBarang(chunk);
                    batchSqlSessionTemplate.flushStatements();
                    log.info("Berhasil insert chunk {}/{} (size={})", chunkIndex, chunks.size(), chunk.size());
                } catch (Exception e) {
                    log.error("Gagal insert chunk {}/{} - error: {}", chunkIndex, chunks.size(), e.getMessage(), e);
                    throw e;
                }
            }
            return new DataResponse<>(
                    SUCCESS,
                    ResponseMessage.DATA_CREATED,
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    loggingHolder.getVersion(),
                    barangList
            );
        } catch (Exception e){
            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (Exception ex){
                log.warn("Tidak bisa set rollback: {}", ex.getMessage());
            }
            log.error("bulkInsertBarang failed - error: {}", e.getMessage(), e);
            response.setResult("Failed");
            response.setDetail(e.getMessage());
            response.setPath(loggingHolder.getPath());
            response.setDate(loggingHolder.getDate());
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setData(null);
            return response;
        }
    }
}
