package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Tipo_contribuyente;
import com.proyectojwt.repository.Tipo_contribuyenteRepository;
import com.proyectojwt.service.ITipo_contribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Tipo_contribuyenteImpl implements ITipo_contribuyenteService {

   @Autowired
    Tipo_contribuyenteRepository tipoContribuyenteRepository;
    @Override

    public Tipo_contribuyente buscarID(int id) {
        return tipoContribuyenteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tipo_contribuyente> listaTipo() {
        List<Tipo_contribuyente> lista = tipoContribuyenteRepository.findAll();
        return lista;
    }

}
