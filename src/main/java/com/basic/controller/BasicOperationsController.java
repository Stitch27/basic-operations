package com.basic.controller;

import com.basic.model.BasicOperationsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.basic.service.BasicOperationsService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/middleware")
public class BasicOperationsController {

    @Autowired
    private BasicOperationsService basicOperationsService;

    @GetMapping("/sky/users/{identifier}")
    public ResponseEntity<Object> consult(@PathVariable("identifier") Long identififer) {
        return basicOperationsService.consult(identififer);
    }

    @PostMapping("/sky/users/")
    public ResponseEntity<Object> register(@RequestBody BasicOperationsRequest basicOperationsRequest){
        return basicOperationsService.register(basicOperationsRequest);
    }

    @PutMapping("/sky/users/")
    public ResponseEntity<Object> update(@RequestBody BasicOperationsRequest basicOperationsRequest){
        return basicOperationsService.update(basicOperationsRequest);
    }

    @DeleteMapping("/sky/users/{identifier}")
    public ResponseEntity<Object> remove(@PathVariable("identifier") Long identififer) {
        return basicOperationsService.remove(identififer);
    }
}
