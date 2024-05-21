package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Condicion_propiedad;
import com.proyectojwt.repository.Condicion_propiedadRepository;
import com.proyectojwt.service.ICondicion_propiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Condicion_propiedadServiceImpl implements ICondicion_propiedadService {

    @Autowired
    Condicion_propiedadRepository condicionPropiedadRepository;

    @Override
    public Condicion_propiedad guardar(Condicion_propiedad em) {
        return condicionPropiedadRepository.save(em);
    }

    @Override
    public List<Condicion_propiedad> listar() {
        List<Condicion_propiedad> lista = condicionPropiedadRepository.findAll();
        return lista;
    }

    @Override
    public Condicion_propiedad buscar(String id) {
        return condicionPropiedadRepository.findById(Integer.valueOf(id)).orElse(null);

    }

    @Override
    public void eliminar(int id) {
condicionPropiedadRepository.deleteById(id);
    }
}
