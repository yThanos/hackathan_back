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
    @Column(name = "SubmissaoId")
    private Integer id;
    @Column(name = "MarcadoresSugeridos")
    private String marcadoresRaw;
    @Column(name = "foiAprovda")
    private Boolean aprovada;

    @Transient
    private List<String> marcadores;
}
