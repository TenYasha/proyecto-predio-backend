package com.proyectojwt.service;

import com.proyectojwt.entity.Rol;

import java.util.List;

public interface IRolService {

    public List<Rol> listRol();

public Rol BuscarRol(Rol rol);
}
