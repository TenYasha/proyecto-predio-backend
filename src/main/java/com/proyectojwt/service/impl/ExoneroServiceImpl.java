package com.proyectojwt.service.impl;

import com.proyectojwt.entity.Exonero;
import com.proyectojwt.repository.ExoneroRepository;
import com.proyectojwt.service.IExoneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExoneroServiceImpl implements IExoneroService {

    @Autowired
    ExoneroRepository exoneroRepository;

    @Override
    public Exonero guardar(Exonero em) {
        return exoneroRepository.save(em);
    }

    @Override
    public List<Exonero> listar() {
        List<Exonero> lista = exoneroRepository.findAll();
        return lista;
    }

    @Override
    public Exonero buscar(String id) {
        return exoneroRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public void eliminar(int id) {
      exoneroRepository.deleteById(id);
    }
}
