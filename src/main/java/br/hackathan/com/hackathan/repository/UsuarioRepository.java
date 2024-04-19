package br.hackathan.com.hackathan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.hackathan.com.hackathan.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Query(value = "SELECT * FROM USUARIO WHERE EMAIL = :email", nativeQuery = true)
    Optional<Usuario> findByEmail(@Param("email") String email);
}
