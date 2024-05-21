package com.proyectojwt.service;


import com.proyectojwt.entity.Tipo_edificacion;

import java.util.List;

public interface ITipo_edificacionService {
    public Tipo_edificacion guardar(Tipo_edificacion em);

    //metodo listar usuarios
    public List<Tipo_edificacion> listar();

    public Tipo_edificacion buscar (String id);

    public void eliminar(int id);
}
