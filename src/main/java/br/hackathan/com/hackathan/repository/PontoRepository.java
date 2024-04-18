package br.hackathan.com.hackathan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.hackathan.com.hackathan.model.PontoAcesso;

@Repository
public interface PontoRepository extends JpaRepository<PontoAcesso, Integer> {
    @Query(name = """
        SELECT * FROM 
            """, nativeQuery = true)
    List<PontoAcesso> findAcessos(int idObra);
    
}
