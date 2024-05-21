package com.proyectojwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_condicion_propiedad")
public class Condicion_propiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_con_propiedad;

    private String nom_condicion_propiedad;
}
