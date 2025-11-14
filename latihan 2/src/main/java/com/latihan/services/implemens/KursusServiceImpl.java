package com.latihan.services.implemens;

import com.latihan.dtos.kursus.KursusPostDto;
import com.latihan.dtos.kursus.KursusResponseDto;
import com.latihan.dtos.kursus.MulaiKursusPostDto;
import com.latihan.exception.InvalidSortParameterException;
import com.latihan.exception.NonExistentResourceException;
import com.latihan.exception.ResourceAlreadyExistException;
import com.latihan.model.entities.Guru;
import com.latihan.model.entities.Kursus;
import com.latihan.model.entities.RuangKelas;
import com.latihan.model.entities.Siswa;
import com.latihan.model.responses.StatusKursus;
import com.latihan.repositories.GuruRepository;
import com.latihan.repositories.KursusRepository;
import com.latihan.repositories.RuangKelasRepository;
import com.latihan.repositories.SiswaRepository;
import com.latihan.services.KursusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class KursusServiceImpl implements KursusService {

    private static final Logger logger = LoggerFactory.getLogger(KursusServiceImpl.class);

    @Autowired
    KursusRepository kursusRepository;

    @Autowired
    GuruRepository guruRepository;

    @Autowired
    RuangKelasRepository ruangKelasRepository;

    @Autowired
    SiswaRepository siswaRepository;

    @Override
    public void addKursus(KursusPostDto kursusAdd) {
        Guru data = guruRepository.getById(kursusAdd.getIdGuru());
        RuangKelas data2 = ruangKelasRepository.getById(kursusAdd.getIdRuangKelas());
        Kursus kursus = new Kursus();
        kursus.setGuru(data);
        kursus.setRuangKelas(data2);
        kursus.setLevel(kursusAdd.getLevel());
        kursus.setNamaKursus(kursusAdd.getNamaKursus());
        kursusRepository.save(kursus);
    }

    @Override
    public Map<String, Object> getKursus(int pageNumber, int pageSize, String sort){
        Pageable pageRequest = this.createKursusPagingRequest(pageNumber, pageSize, sort);
        Page<Kursus> kursusResponseDtoPage = kursusRepository.findAll(pageRequest);
        List<Kursus> data = kursusResponseDtoPage.getContent();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("kursus", data);
        response.put("currentPage", kursusResponseDtoPage.getNumber());
        response.put("totalItems", kursusResponseDtoPage.getTotalElements());
        response.put("totalPage", kursusResponseDtoPage.getTotalPages());
        return response;
    }

    private KursusResponseDto toDto(Kursus kursus){
        KursusResponseDto kursusResponseDto = new KursusResponseDto();
        kursusResponseDto.setIdKursus(kursus.getIdKursus());
        kursusResponseDto.setNamaKursus(kursus.getNamaKursus());
        kursusResponseDto.setLevel(kursus.getLevel());
        kursusResponseDto.setGuru(kursus.getGuru());
        return kursusResponseDto;
    }

    @Override
    public Optional<Kursus> getKursusById(UUID idKursus) throws NonExistentResourceException {
        Optional<Kursus> data = kursusRepository.findById(idKursus);
        if (!data.isPresent()){
            logger.error("cannot find kursus : with id " + idKursus);
            throw new NonExistentResourceException("cannot find kursus : with id " + idKursus);
        }
        return data;
    }

    @Override
    public Kursus editKursusById(Kursus kursus) throws NonExistentResourceException{
        Optional<Kursus> data = kursusRepository.findById(kursus.getIdKursus());
        if (!data.isPresent()){
            logger.error("cannot find kursus : with id " + kursus.getIdKursus());
            throw new NonExistentResourceException("cannot find kursus : with id " + kursus.getIdKursus());
        }
        data.get().setNamaKursus(kursus.getNamaKursus());
        data.get().setLevel(kursus.getLevel());
        return kursusRepository.save(data.get());
    }

    @Override
    public void deleteKursusById(UUID idKursus) throws NonExistentResourceException{
        Optional<Kursus> data = kursusRepository.findById(idKursus);
        if (!data.isPresent()){
            logger.error("cannot find kursus : with id " + idKursus);
            throw new NonExistentResourceException("cannot find kursus : with id " + idKursus);
        }
        kursusRepository.deleteById(idKursus);
    }

    public void mulaiKursus(MulaiKursusPostDto mulaiKursusPostDto){
        //id siswa & id Kursus
        Siswa data = siswaRepository.getById(mulaiKursusPostDto.getIdSiswa());
        Kursus data2 = kursusRepository.getById(mulaiKursusPostDto.getIdKursus());

        //cek kondisi apakah sudah bayar atau belum

    }

    public void selesaiKursus(){

    }
    // ------------------------------------------ utilities ------------------------------------------------

    private Pageable createKursusPagingRequest(int pageNumber, int pageSize, String sort){
        Pageable pageRequest;
        switch (sort) {
            case "nameAsc" :
                pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("namaKursus"));
                break;
            default:
                throw new InvalidSortParameterException("invalid sort parameter");
        }
        return pageRequest;
    }
}
