package com.latihan.services.implemens;

import com.latihan.exception.NonExistentResourceException;
import com.latihan.exception.ResourceAlreadyExistException;
import com.latihan.model.entities.DaftarKursus;
import com.latihan.model.responses.StatusKursus;
import com.latihan.repositories.DaftarKursusRepository;
import com.latihan.services.DaftarKursusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DaftarKursusServiceImpl implements DaftarKursusService {

    public static final Logger logger = LoggerFactory.getLogger(DaftarKursusServiceImpl.class);

    @Autowired
    DaftarKursusRepository daftarKursusRepository;

    @Override
    public void addDaftarKursus(DaftarKursus daftarKursusAdd) throws NonExistentResourceException {
        daftarKursusAdd.setIdDaftarKursus(UUID.randomUUID());
        Optional<DaftarKursus> data = daftarKursusRepository.findById(daftarKursusAdd.getIdDaftarKursus());
        String status = daftarKursusAdd.getStatus();
        switch (status){
            case "1" :
                StatusKursus.BELUM_TERDAFTAR.getMessage();
                break;
            case "2" :
                StatusKursus.TERDAFTAR.getMessage();
        }
        if (daftarKursusAdd.getStatus() == "1"){
            StatusKursus.BELUM_TERDAFTAR_KURSUS.getMessage();
        } else {
            switch (daftarKursusAdd.getStatusKursus()){
                case "bahasaIndonesia" :
                    StatusKursus.TERDAFTAR_DIKELAS_BAHASAINDONESIA.getMessage();
                    break;
                case "kimiaFarmasi" :
                    StatusKursus.TERDAFTAR_DIKELAS_KIMIAFARMASI.getMessage();
                    break;
                case "matematikaFisika" :
                    StatusKursus.TERDAFTAR_DIKELAS_MATEMATIKAFISIKA.getMessage();
                    break;
                case "anatomiTubuh" :
                    StatusKursus.TERDAFTAR_DIKELAS_ANATOMITUBUH.getMessage();
                    break;
                case "bahasaInggris" :
                    StatusKursus.TERDAFTAR_DIKELAS_BAHASAINGGRIS.getMessage();
                    break;
                default:
                    throw new NonExistentResourceException("pilihan tidak tersedia");
            }
        }

        if (daftarKursusAdd.getStatus() == "1"){
            StatusKursus.BELUM_TERDAFTAR_KURSUS.getMessage();
        }else {
            switch (daftarKursusAdd.getKateranganStatus()){
                case "masaKursus" :
                    StatusKursus.MASA_KURSUS.getMessage();
                    break;
                case "selesai" :
                    StatusKursus.SELESAI.getMessage();
                    break;
                default:
                    throw new NonExistentResourceException("pilihan tidak tersedia");
            }
        }
        daftarKursusRepository.save(daftarKursusAdd);
    }


}
