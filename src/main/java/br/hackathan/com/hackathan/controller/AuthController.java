package br.hackathan.com.hackathan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hackathan.com.hackathan.model.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("path")
    public ResponseEntity<Object> login(@RequestBody Usuario user) {
        
        return ResponseEntity.ok().build();
    }
    
}
