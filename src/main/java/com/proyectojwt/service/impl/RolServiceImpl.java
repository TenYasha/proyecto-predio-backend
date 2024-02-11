package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Rol;
import com.proyectojwt.repository.RolRepository;
import com.proyectojwt.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> listRol() {
        List<Rol> lista = rolRepository.findAll();
        return lista;
    }

    @Override
    public Rol BuscarRol(Rol rol) {
        return rolRepository.findByNombre(rol);
    }
}
