package com.example.sql;

import org.springframework.data.repository.CrudRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

import com.example.sql.service;
//@CrossOrigin(origins = "http://localhost:4200")
    public interface dao extends CrudRepository<service, Long> {

    List<service> findByEmail(String email);
    Optional<service> findById(Integer id);
	Optional<service> deleteById(int id);


    }

