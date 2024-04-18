package br.hackathan.com.hackathan.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Submissao")
@Entity
public class Submissao {
    @Id
    @Column(name = "ID_SUBMISSAO")
    private Integer id;
    @Column(name = "ID_ITEM")
    private Integer idItem;
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "DATA_SUBMISSAO")
    private String dataSubmissao;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DATAS")
    private String datas;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "APROVADA")
    private Boolean aprovada;

    @Transient
    private List<PontoAcesso> pontosAcesso;
}
/**
 * ID_SUBMISSAO SERIAL PRIMARY KEY,
    ID_ITEM INTEGER,
    ID_USUARIO INTEGER,
    DATA_SUBMISSAO TIMESTAMP,
    TITULO VARCHAR(60),
    DATAS VARCHAR(60),
    CONTENT TEXT,
    APROVADA BOOLEAN,
 */