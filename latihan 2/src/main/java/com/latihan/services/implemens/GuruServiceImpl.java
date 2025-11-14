package com.latihan.services.implemens;

import com.latihan.exception.InvalidSortParameterException;
import com.latihan.exception.NonExistentResourceException;
import com.latihan.exception.ResourceAlreadyExistException;
import com.latihan.model.entities.Guru;
import com.latihan.repositories.GuruRepository;
import com.latihan.services.GuruService;
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
public class GuruServiceImpl implements GuruService {

    public static final Logger logger = LoggerFactory.getLogger(GuruServiceImpl.class);

    @Autowired
    GuruRepository guruRepository;

    @Override
    public void addGuru(Guru guruAdd) throws ResourceAlreadyExistException {
        Optional<Guru> data = guruRepository.findById(guruAdd.getIdGuru());
        if (!data.isPresent()){
            logger.error(guruAdd.getIdGuru() + "id already exist");
            throw new ResourceAlreadyExistException(guruAdd.getIdGuru() + "id already exist");
        }
        guruRepository.save(guruAdd);
    }

    @Override
    public Map<String, Object> getGuru(int pageNumber, int pageSize, String sort){
        Pageable pageRequest = this.createGuruPagingRequest(pageNumber, pageSize, sort);
        Page<Guru> guruPage = guruRepository.findAll(pageRequest);
        List<Guru> data = guruPage.getContent();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("gurus", data);
        response.put("currentPage", guruPage.getNumber());
        response.put("totalItems", guruPage.getTotalElements());
        response.put("totalPage", guruPage.getTotalPages());
        return response;
    }

    @Override
    public Optional<Guru> getGuruById(UUID idGuru) throws NonExistentResourceException {
        Optional<Guru> data = guruRepository.findById(idGuru);
        if (!data.isPresent()){
            logger.error("cannot find guru : with id " + idGuru + "doesnt exist");
            throw new NonExistentResourceException("cannot find guru : with id " + idGuru + "doesnt exist");
        }
        return data;
    }

    @Override
    public Guru editGuruById(Guru guru)throws NonExistentResourceException{
        Optional<Guru> data = guruRepository.findById(guru.getIdGuru());
        if (!data.isPresent()){
            logger.error("cannot find guru : with id " + guru.getIdGuru());
            throw new NonExistentResourceException("cannot find guru : with id " + guru.getIdGuru());
        }
        data.get().setNamaGuru(guru.getNamaGuru());
        data.get().setSpesialisasi(guru.getSpesialisasi());
        return guruRepository.save(data.get());
    }

    @Override
    public void deleteGuruById(UUID idGuru)throws NonExistentResourceException{
        Optional<Guru> data = guruRepository.findById(idGuru);
        if (!data.isPresent()){
            logger.error("cannot find guru : with id " + idGuru);
            throw new NonExistentResourceException("cannot find guru : with id " + idGuru);
        }
        guruRepository.deleteById(idGuru);
    }

    // ------------------------------------------ utilities ------------------------------------------------

    private Pageable createGuruPagingRequest(int pageNumber, int pageSize, String sort){
        Pageable pageRequest;
        switch (sort) {
            case "nameAsc" :
                pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("namaGuru"));
                break;
            default:
                throw new InvalidSortParameterException("invalid sort parameter");
        }
        return pageRequest;
    }
}
