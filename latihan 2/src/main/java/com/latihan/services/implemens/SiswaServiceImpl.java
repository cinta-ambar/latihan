package com.latihan.services.implemens;

import com.latihan.exception.InvalidSortParameterException;
import com.latihan.exception.NonExistentResourceException;
import com.latihan.exception.ResourceAlreadyExistException;
import com.latihan.model.entities.Siswa;
import com.latihan.repositories.KursusRepository;
import com.latihan.repositories.SiswaRepository;
import com.latihan.services.SiswaService;
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
public class SiswaServiceImpl implements SiswaService {

    private static final Logger logger = LoggerFactory.getLogger(SiswaServiceImpl.class);

    @Autowired
    SiswaRepository siswaRepository;

    @Autowired
    KursusRepository kursusRepository;


    @Override
    public void addSiswa(Siswa siswaAdd) throws ResourceAlreadyExistException {
        Optional<Siswa> data = siswaRepository.findById(siswaAdd.getIdSiswa());
        if (data.isPresent()){
            logger.error(siswaAdd.getIdSiswa() + "Id already exist");
            throw new ResourceAlreadyExistException(siswaAdd.getIdSiswa() + "Id already exist");
        }
        siswaRepository.save(siswaAdd);
    }

    @Override
    public Map<String, Object> getSiswa(int pageNumber, int pageSize, String sort) {
        Pageable pageRequest = this.createStudentPagingRequest(pageNumber, pageSize, sort);
        Page<Siswa> siswaPage = siswaRepository.findAll(pageRequest);
        List<Siswa> data = siswaPage.getContent();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("siswa", data);
        response.put("currentPage", siswaPage.getNumber());
        response.put("totalItems", siswaPage.getTotalElements());
        response.put("totalPage", siswaPage.getTotalPages());
        return response;
    }

    @Override
    public Optional<Siswa> getSiswaById(UUID idSiswa) throws NonExistentResourceException {
        Optional<Siswa> data = siswaRepository.findById(idSiswa);
        if (!data.isPresent()){
            logger.error("cannot find siswa : with id " + idSiswa + "doesnt exist");
            throw new NonExistentResourceException("cannot find siswa : with id " + idSiswa + "doesnt exist");
        }
        return data;
    }

    @Override
    public Siswa editSiswaById(Siswa siswa) throws NonExistentResourceException{
        Optional<Siswa> data = siswaRepository.findById(siswa.getIdSiswa());
        if (!data.isPresent()){
            logger.error("cannot find siswa : with id " + siswa.getIdSiswa() + "doesnt exist");
            throw new NonExistentResourceException("cannot find siswa : with id " + siswa.getIdSiswa() + "doesnt exist");
        }
        data.get().setNamaSiswa(siswa.getNamaSiswa());
        data.get().setBatch(siswa.getBatch());
        return siswaRepository.save(data.get());
    }

    @Override
    public void deleteSiswaById(UUID idSiswa) throws NonExistentResourceException{
        Optional<Siswa> data = siswaRepository.findById(idSiswa);
        if (!data.isPresent()){
            logger.error("cannot find siswa : with id " + idSiswa + "doesnt exist");
            throw new NonExistentResourceException("cannot find siswa : with id " + idSiswa + "doesnt exist");
        }
        siswaRepository.deleteById(idSiswa);
    }

    public List<Siswa> getSiswaByNama(String keyword){
         List<Siswa> data = siswaRepository.findByNamaSiswaContainingIgnoreCaseOrBatchContainingIgnoreCase(keyword, keyword);
         return data;
    }

//    public void addBelajar(KursusSiswaDto kursusSiswaDtoAdd){
//        Siswa dataSiswa = siswaRepository.getById(kursusSiswaDtoAdd.getIdSiswa());
//        Kursus dataKursus = kursusRepository.getById(kursusSiswaDtoAdd.getIdKursus());
//
//        kursusSiswaDto.setIdSiswa(dataSiswa.getIdSiswa());
//        kursusSiswaDto.setIdKursus(dataKursus.getIdKursus());
//
//    }

    //--------------------------------------------- utilities ------------------------------------

    private Pageable createStudentPagingRequest(int pageNumber, int pageSize, String sort){
        Pageable pageRequest;
        switch (sort) {
            case "namaSiswaAsc" :
                pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("namaSiswa"));
                break;
            default:
                throw new InvalidSortParameterException("invalid sort parameter");
        }
        return pageRequest;
    }


}
