package com.javamaster.repository;

import com.javamaster.entity.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ElectronicRepo extends JpaRepository<Electronic, Long> {
    Electronic findByNameModel(String nameModel);
}
