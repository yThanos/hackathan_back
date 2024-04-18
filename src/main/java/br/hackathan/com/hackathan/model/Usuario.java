package br.hackathan.com.hackathan.model;

import java.util.Date;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "APELIDO")
    private String apelido;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "QTD_PONTOS")
    private Integer qtdPontos;
    @Column(name = "ETNIA")
    private String etnia;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "RELIGIAO")
    private String religiao;
    @Column(name = "IS_ADMIN")
    private Boolean isAdmin;
}
/**ID_USUARIO SERIAL PRIMARY KEY,
    NOME VARCHAR(60),
    APELIDO VARCHAR(30),
    EMAIL VARCHAR(60),
    SENHA VARCHAR(60),
    DATA_NASCIMENTO DATE,
    ESTADO VARCHAR(2),
    CIDADE VARCHAR(60),
    QTD_PONTOS INTEGER,
    ETNIA VARCHAR(60),
    GENERO VARCHAR(60),
    RELIGIAO VARCHAR(60),
    IS_ADMIN BOOLEAN */