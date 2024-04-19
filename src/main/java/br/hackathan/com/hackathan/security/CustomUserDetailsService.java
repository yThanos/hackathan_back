package br.hackathan.com.hackathan.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.hackathan.com.hackathan.model.Usuario;
import br.hackathan.com.hackathan.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: " + username);

        Optional<Usuario> user = usuarioRepository.findByEmail(username);

        System.out.println("User: " + user);
        if(user.isPresent()) {
            return User.withUsername(user.get().getEmail())
            .password(new BCryptPasswordEncoder().encode(user.get().getSenha()))
            .roles("ADMIN").build();
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
    
}
