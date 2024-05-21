package com.proyectojwt.service;

import com.proyectojwt.entity.Exonero;
import com.proyectojwt.entity.Situacion;

import java.util.List;

public interface ISituacionService {
    public Situacion guardar(Situacion em);

    //metodo listar usuarios
    public List<Situacion> listar();

    public Situacion buscar (String id);

    public void eliminar(int id);
}
