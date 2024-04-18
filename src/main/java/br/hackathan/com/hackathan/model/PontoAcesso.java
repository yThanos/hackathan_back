package br.hackathan.com.hackathan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "PontoAcessoId")
    private Integer id;
    @Column(name = "AcessoDescr")
    private String descricao;
    @Column(name = "AcessoIndice")
    private String indice;

}
