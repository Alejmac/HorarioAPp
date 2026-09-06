package com.alejandro.horarioaplicacion.springboot_horarioapp.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class AppController {

    @GetMapping("/foo") 
    public ResponseEntity<?> foo (){

        Map<String,Object> data = Collections.singletonMap("title", "bienvenidos al sistema de horario");
        return ResponseEntity.ok(data);
    }
}
