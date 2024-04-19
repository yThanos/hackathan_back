package br.hackathan.com.hackathan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hackathan.com.hackathan.model.PontoAcesso;

@Repository
public interface PontoRepository extends JpaRepository<PontoAcesso, Integer> {
    
}
