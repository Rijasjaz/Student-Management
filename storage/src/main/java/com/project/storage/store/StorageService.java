package com.project.storage.store;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class StorageService {

    @Autowired
    public StorageRepository storageRepository;
    @Autowired
    public Pdfexport pdfexport;

    @Value("${path.pdf}")
    public String pdfPath;

    public String date(){
        SimpleDateFormat dt= new SimpleDateFormat("ddMMyyyy_HHmmss");
        String date1=dt.format(new Date());
        return date1;
    }

    public Storage create(Storage storage){
        return storageRepository.save(storage);
    }

    public List<Storage> get(){

        return storageRepository.findAll();
    }
    public Storage find(Long id){
        return storageRepository.findById(id).get();
    }

    public Storage update(Long id,Storage storage){
        Storage str=storageRepository.findById(id).get();
        str.setFirstname(storage.getFirstname());
        str.setLastname(storage.getLastname());
        str.setDob(storage.getDob());
        str.setContact(storage.getContact());
        str.setEmail(storage.getEmail());
        str.setGender(storage.getGender());
        str.setQualification(storage.getQualification());
        return storageRepository.save(str);
    }

    public void delete(Long id){
        storageRepository.deleteById(id);
    }

    public void download() throws DocumentException, IOException {
        List<Storage> list=storageRepository.findAll();
        pdfexport.listToPdf(list,pdfPath+date()+".pdf");
    }


}
