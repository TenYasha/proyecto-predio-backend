package com.proyectojwt.service;

import com.proyectojwt.entity.Tipo_contribuyente;

import java.util.List;

public interface ITipo_contribuyenteService {

    public Tipo_contribuyente buscarID(int id);

    public List<Tipo_contribuyente> listaTipo();
}
