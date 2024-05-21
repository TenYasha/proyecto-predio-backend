package com.proyectojwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_tipo_edificacion")
public class Tipo_edificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_edi;

    private String nom_tipo;

}
