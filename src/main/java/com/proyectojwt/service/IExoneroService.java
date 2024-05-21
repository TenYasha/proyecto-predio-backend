package com.proyectojwt.service;

import com.proyectojwt.entity.Exonero;

import java.util.List;

public interface IExoneroService {
    public Exonero guardar(Exonero em);

    //metodo listar usuarios
    public List<Exonero> listar();

    public Exonero buscar (String id);

    public void eliminar(int id);
}
