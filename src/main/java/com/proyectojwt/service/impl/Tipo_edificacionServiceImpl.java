package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Tipo_edificacion;
import com.proyectojwt.repository.Tipo_edificacionRepository;
import com.proyectojwt.service.ITipo_edificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_edificacionServiceImpl implements ITipo_edificacionService {

    @Autowired
    Tipo_edificacionRepository tipoEdificacionRepository;

    @Override
    public Tipo_edificacion guardar(Tipo_edificacion em) {
        return tipoEdificacionRepository.save(em);
    }

    @Override
    public List<Tipo_edificacion> listar() {
        List<Tipo_edificacion> lista = tipoEdificacionRepository.findAll();
        return lista;
    }

    @Override
    public Tipo_edificacion buscar(String id) {
        return tipoEdificacionRepository.findById(Integer.valueOf(id)).orElse(null);

    }

    @Override
    public void eliminar(int id) {
tipoEdificacionRepository.deleteById(id);
    }
}
