package com.proyectojwt.service;

import com.proyectojwt.entity.Condicion_propiedad;

import java.util.List;

public interface ICondicion_propiedadService {

    public Condicion_propiedad guardar(Condicion_propiedad em);

    //metodo listar usuarios
    public List<Condicion_propiedad> listar();

    public Condicion_propiedad buscar (String id);

    public void eliminar(int id);
}
