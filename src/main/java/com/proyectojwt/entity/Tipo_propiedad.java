package com.proyectojwt.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_tipo_propiedad")
public class Tipo_propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_propiedad;

    private String nom_tipo_propiedad;


}
