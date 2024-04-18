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
@Table(name = "Obras")
@Entity
public class Obra {
    @Id
    @Column(name = "CodReferencia")
    private String codReferencia;
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "LocalCriacao")
    private String localCriacao;
    @Column(name = "DataCriacao")
    private String dataCriacao;
    @Column(name = "ConteudoDescricao")
    private String descricao;
    @Column(name = "MarcadoresSociaisDeDiferenca")
    private String marcadoresSociaisDeDiferenca;
    
    @Transient
    private List<PontoAcesso> tags;

}
