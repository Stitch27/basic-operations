package com.sky.basic.service;

import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.sky.basic.entity.BasicOperationsEntity;
import com.sky.basic.model.BasicOperationsRequest;
import com.sky.basic.repository.BasicOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BasicOperationsService {

    @Autowired
    private BasicOperationsRepository basicOperationsRepository;

    public ResponseEntity<Object> consult(Long identifier){

        HashMap<String, String> result = new LinkedHashMap<>();
        HashMap<String, Object> response = new LinkedHashMap<>();
        HashMap<String, String> information = new LinkedHashMap<>();

        BasicOperationsEntity basicOperationsEntity = basicOperationsRepository.getReferenceById(identifier);

        result.put("code", "100");
        result.put("description", "Petición realizada con éxito.");

        information.put("name", basicOperationsEntity.getName());
        information.put("account", basicOperationsEntity.getAccount());

        response.put("result", result);
        response.put("information", information);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    public ResponseEntity<Object> register(BasicOperationsRequest basicOperationsRequest){

        LocalDateTime date = LocalDateTime.now();
        HashMap<String, String> result = new LinkedHashMap<>();
        HashMap<String, Object> response = new LinkedHashMap<>();

        BasicOperationsEntity basicOperationsEntity = new BasicOperationsEntity();

        basicOperationsEntity.setIdentifier(Long.parseLong(basicOperationsRequest.getIdentififer()));
        basicOperationsEntity.setAccount(basicOperationsRequest.getAccount());
        basicOperationsEntity.setName(basicOperationsRequest.getName());
        basicOperationsEntity.setLastName(basicOperationsRequest.getLastName());
        basicOperationsEntity.setEmail(basicOperationsRequest.getEmail());
        basicOperationsEntity.setCode(basicOperationsRequest.getCode());
        basicOperationsEntity.setCreationDate(date);
        basicOperationsEntity.setUpdateDate(date);

        basicOperationsRepository.save(basicOperationsEntity);

        result.put("code", "100");
        result.put("description", "Petición realizada con éxito.");

        response.put("result", result);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    public ResponseEntity<Object> remove(Long identifier){

        basicOperationsRepository.deleteById(identifier);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<Object> update(BasicOperationsRequest basicOperationsRequest){

        LocalDateTime date = LocalDateTime.now();
        HashMap<String, String> result = new LinkedHashMap<>();
        HashMap<String, Object> response = new LinkedHashMap<>();

        BasicOperationsEntity basicOperationsEntity = new BasicOperationsEntity();

        basicOperationsEntity.setIdentifier(Long.parseLong(basicOperationsRequest.getIdentififer()));
        basicOperationsEntity.setAccount(basicOperationsRequest.getAccount());
        basicOperationsEntity.setName(basicOperationsRequest.getName());
        basicOperationsEntity.setLastName(basicOperationsRequest.getLastName());
        basicOperationsEntity.setEmail(basicOperationsRequest.getEmail());
        basicOperationsEntity.setCode(basicOperationsRequest.getCode());
        basicOperationsEntity.setCreationDate(date);
        basicOperationsEntity.setUpdateDate(date);

        basicOperationsRepository.save(basicOperationsEntity);

        result.put("code", "100");
        result.put("description", "Petición realizada con éxito.");

        response.put("result", result);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

}
