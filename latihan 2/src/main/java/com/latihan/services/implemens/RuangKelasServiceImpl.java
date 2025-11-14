package com.latihan.services.implemens;

import com.latihan.exception.InvalidSortParameterException;
import com.latihan.exception.NonExistentResourceException;
import com.latihan.exception.ResourceAlreadyExistException;
import com.latihan.model.entities.RuangKelas;
import com.latihan.repositories.RuangKelasRepository;
import com.latihan.services.RuangKelasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RuangKelasServiceImpl implements RuangKelasService {
    @Autowired
    RuangKelasRepository ruangKelasRepository;

    public static final Logger logger = LoggerFactory.getLogger(RuangKelasServiceImpl.class);

    @Override
    public void addRuangKelas(RuangKelas ruangKelasAdd) throws ResourceAlreadyExistException {
        Optional<RuangKelas> data = ruangKelasRepository.findById(ruangKelasAdd.getIdRuangKelas());
        if (data.isPresent()){
            logger.error("cannot find ruang kelas : with id " + ruangKelasAdd.getIdRuangKelas() + "doesnt exist");
            throw new NonExistentResourceException("cannot find ruang kelas : with id " + ruangKelasAdd.getIdRuangKelas() + "doesnt exist");
        }
        ruangKelasRepository.save(ruangKelasAdd);
    }

    @Override
    public Map<String, Object> getRuangKelas(int pageNumber, int pageSize, String sort){
        Pageable pageRequest = this.createRuangKelasPagingRequest(pageNumber, pageSize, sort);
        Page<RuangKelas> ruangKelasPage = ruangKelasRepository.findAll(pageRequest);
        List<RuangKelas> data = ruangKelasPage.getContent();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("ruangKelas", data);
        response.put("currentPage", ruangKelasPage.getNumber());
        response.put("totalItems", ruangKelasPage.getTotalElements());
        response.put("totalPage", ruangKelasPage.getTotalPages());
        return response;
    }

    @Override
    public Optional<RuangKelas> getRuangKelasById(UUID idRuangKelas) throws NonExistentResourceException{
        Optional<RuangKelas> data = ruangKelasRepository.findById(idRuangKelas);
        if (!data.isPresent()){
            logger.error("cannot find ruang kelas : with id " + idRuangKelas);
            throw new NonExistentResourceException("cannot find ruang kelas : with id " + idRuangKelas);
        }
        return data;
    }

    @Override
    public RuangKelas editRuangKelasById(RuangKelas ruangKelas) throws NonExistentResourceException{
        Optional<RuangKelas> data = ruangKelasRepository.findById(ruangKelas.getIdRuangKelas());
        if (!data.isPresent()){
            logger.error("cannot find ruang kelas : with id " + ruangKelas.getIdRuangKelas());
            throw new NonExistentResourceException("cannot find ruang kelas : with id " + ruangKelas.getIdRuangKelas());
        }
        data.get().setNamaKelas(ruangKelas.getNamaKelas());
        data.get().setKapasitas(ruangKelas.getKapasitas());
        data.get().setJadwal(ruangKelas.getJadwal());
        return ruangKelasRepository.save(data.get());
    }

    @Override
    public void deleteRuangKelasById(UUID idRuangKelas) throws NonExistentResourceException{
        Optional<RuangKelas> data = ruangKelasRepository.findById(idRuangKelas);
        if (!data.isPresent()){
            logger.error("cannot find ruang kelas : with id " + idRuangKelas);
            throw new NonExistentResourceException("cannot find ruang kelas : with id " + idRuangKelas);
        }
        ruangKelasRepository.deleteById(idRuangKelas);
    }

    // ------------------------------------------ utilities ------------------------------------------------

    private Pageable createRuangKelasPagingRequest(int pageNumber, int pageSize, String sort){
        Pageable pageRequest;
        switch (sort) {
            case "nameAsc" :
                pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("namaKelas"));
                break;
            default:
                throw new InvalidSortParameterException("invalid sort parameter");
        }
        return pageRequest;
    }
}
