package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Contribuyente;
import com.proyectojwt.repository.ContribuyenteRepository;
import com.proyectojwt.service.IContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuyenteServiceImpl implements IContribuyenteService {

    @Autowired
    ContribuyenteRepository contribuyenteRepository;

    @Override
    public Contribuyente guardar(Contribuyente conti) {
        return contribuyenteRepository.save(conti);
    }

    @Override
    public Contribuyente buscar(String nom) {
        return contribuyenteRepository.findById(Integer.valueOf(nom)).orElse(null);
    }

    @Override
    public List<Contribuyente> listarContribuyente() {
    List<Contribuyente> lista = contribuyenteRepository.findAll();
        return lista;
    }

    @Override
    public void eliminar_usuario(int id) {
contribuyenteRepository.deleteById(id);
    }
}
