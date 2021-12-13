package com.javamaster.service;

import com.javamaster.entity.Electronic;
import com.javamaster.repository.ElectronicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectronicService {

    @Autowired
    private ElectronicRepo electronicRepo;

    public ResponseEntity<?> addElectronic(Electronic electronic) {
        if (electronicRepo.findByNameModel(electronic.getNameModel()) != null) {
            return new ResponseEntity<>(electronic, HttpStatus.ALREADY_REPORTED);
        }
        electronicRepo.save(electronic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Electronic> getElectronic(Long id) {
        Optional<Electronic> row = electronicRepo.findById(id);
        if(row.isPresent())
            return new ResponseEntity<>(row.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Electronic>> getElectronics() {
        List<Electronic> list = electronicRepo.findAll();
        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteElectronic(Long id) {
        Optional<Electronic> row = electronicRepo.findById(id);
        if (!row.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        electronicRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
