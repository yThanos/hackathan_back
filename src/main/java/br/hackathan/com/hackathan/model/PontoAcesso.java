package br.hackathan.com.hackathan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PontoAcesso")
@Entity
public class PontoAcesso {
    @Id
    @Column(name = "ID_PONTOS_ACESSO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "DESCR_PONTO")
    private String descricao;
    @Column(name = "INDICE_PONTO")
    private Integer indice;

}
/**
 * 
    ID_PONTOS_ACESSO SERIAL PRIMARY KEY,
    DESCR_PONTO VARCHAR(60),
    INDICE_PONTO INTEGER
 */