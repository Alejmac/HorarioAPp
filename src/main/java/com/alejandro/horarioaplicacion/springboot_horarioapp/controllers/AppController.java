package com.alejandro.horarioaplicacion.springboot_horarioapp.controllers;

  
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class AppController {

    @GetMapping("/foo") 
    public ResponseEntity<?> foo (){

        Map<String,Object> data = new HashMap<>();
        data.put("title", "bienvenidos al sistema de horario");
        data.put("Date", new Date());
        return ResponseEntity.ok(data);
     }
}
