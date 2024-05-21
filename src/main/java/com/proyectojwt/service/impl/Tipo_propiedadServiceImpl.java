package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Tipo_propiedad;
import com.proyectojwt.repository.Tipo_propiedadRepository;
import com.proyectojwt.service.ITipo_propiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_propiedadServiceImpl implements ITipo_propiedadService {

    @Autowired
    Tipo_propiedadRepository tipoPropiedadRepository;

    @Override
    public Tipo_propiedad guardar(Tipo_propiedad em) {
        return tipoPropiedadRepository.save(em);
    }

    @Override
    public List<Tipo_propiedad> listar() {
        List<Tipo_propiedad> lista = tipoPropiedadRepository.findAll();
        return lista;
    }

    @Override
    public Tipo_propiedad buscar(String id) {
        return tipoPropiedadRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public void eliminar(int id) {
tipoPropiedadRepository.deleteById(id);
    }
}
