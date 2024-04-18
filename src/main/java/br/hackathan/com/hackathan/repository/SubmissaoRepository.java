package br.hackathan.com.hackathan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hackathan.com.hackathan.model.Submissao;

@Repository
public interface SubmissaoRepository extends JpaRepository<Submissao, Integer> {
    
}
