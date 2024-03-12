package com.proyectojwt.service;

import com.proyectojwt.entity.Contribuyente;

import java.util.List;

public interface IContribuyenteService {
    public Contribuyente guardar(Contribuyente conti);
    public Contribuyente buscar(String nom);
    public List<Contribuyente> listarContribuyente();
    public void eliminar_usuario(int id);

}
