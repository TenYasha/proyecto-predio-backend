package com.proyectojwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_situacion")
public class Situacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_situacion;

    private String nom_situacion;

}
