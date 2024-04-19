package br.hackathan.com.hackathan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hackathan.com.hackathan.Util.JwtUtil;
import br.hackathan.com.hackathan.model.Usuario;
import br.hackathan.com.hackathan.repository.UsuarioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;

    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario user) {
        System.out.println(user.getEmail() + " " + user.getSenha());
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getSenha())
        );
        System.out.println("Teste");
        if(authentication.isAuthenticated()) {
            String token = JwtUtil.generateToken(user.getEmail());
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        System.out.println("Credenciais inválidas");
        return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Usuario user) {
        usuarioRepository.save(user);
        return ResponseEntity.ok("Usuario criado com sucesso");
    }
    
}
