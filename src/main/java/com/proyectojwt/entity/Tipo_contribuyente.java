package com.proyectojwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name ="tb_tipo_contribuyente")
public class Tipo_contribuyente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_contribuyente;

    private String nom_tipo;
    @JsonIgnore
    @OneToOne(mappedBy = "tipo_contribuyente")
    private Contribuyente contribuyente;


}
