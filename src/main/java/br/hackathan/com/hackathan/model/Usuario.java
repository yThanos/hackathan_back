package br.hackathan.com.hackathan.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @Column(name = "UsuarioId")
    private Integer id;
    @Column(name = "NomeCompleto")
    private String nome;
    @Column(name = "UsuarioApelido")
    private String apelido;
    @Column(name = "UsuarioEmail")
    private String email;
    @Column(name = "UsuarioSenha")
    private String senha;
    @Column(name = "UsuarioNascimento")
    private Date nascimento;
    @Column(name = "UsuarioCidade")
    private String cidade;
    @Column(name = "UsuarioEstado")
    private String estado;
    @Column(name = "QtdPontos")
    private Integer pontos;
    @Column(name = "IdentOrigemEtnica")
    private String etnia;
    @Column(name = "IdentGenero")
    private String genero;
    @Column(name = "IdentFiliacaoReligiosa")
    private String religiao;
}
