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
@Table(name = "Item")
@Entity
public class Item {
    @Id
    @Column(name = "ID_ITEM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "COD_REFERENCIA")
    private String codReferencia;
    @Column(name = "TIPO_ITEM")
    private String tipoItem;
    
}
/**
 * COD_REFERENCIA VARCHAR(255) PRIMARY KEY,
    ID_ITEM INTEGER,
    TIPO_ITEM VARCHAR(20)
 */