package br.hackathan.com.hackathan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hackathan.com.hackathan.model.Obra;

@Repository
public interface ObraRepository extends JpaRepository<Obra, String> {
    
}
