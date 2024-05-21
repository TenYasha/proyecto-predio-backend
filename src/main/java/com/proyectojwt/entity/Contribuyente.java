package com.proyectojwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_contribuyente")
public class Contribuyente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contribuyente;

    private int dni;
    private String nom_contribuyente;
    private String ape_contribuyente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    private Tipo_contribuyente tipo_contribuyente;
}
