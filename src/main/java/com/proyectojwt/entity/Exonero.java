package com.proyectojwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_exonero")
public class Exonero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exonero;

    private String nom_exonero;
}
