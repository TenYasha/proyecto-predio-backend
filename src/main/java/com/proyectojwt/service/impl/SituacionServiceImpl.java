package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Situacion;
import com.proyectojwt.repository.SituacionRepository;
import com.proyectojwt.service.ISituacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacionServiceImpl implements ISituacionService {

    @Autowired
    SituacionRepository situacionRepository;
    @Override
    public Situacion guardar(Situacion em) {
        return situacionRepository.save(em);
    }

    @Override
    public List<Situacion> listar() {
        List<Situacion> lista = situacionRepository.findAll();
        return lista;
    }

    @Override
    public Situacion buscar(String id) {
        return situacionRepository.findById((Integer.valueOf(id))).orElse(null);
    }

    @Override
    public void eliminar(int id) {
       situacionRepository.deleteById(id);
    }
}
