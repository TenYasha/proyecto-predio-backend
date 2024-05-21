package com.proyectojwt.service;

import com.proyectojwt.entity.Exonero;
import com.proyectojwt.entity.Tipo_propiedad;

import java.util.List;

public interface ITipo_propiedadService {
    public Tipo_propiedad guardar(Tipo_propiedad em);

    //metodo listar usuarios
    public List<Tipo_propiedad> listar();

    public Tipo_propiedad buscar (String id);

    public void eliminar(int id);
}
