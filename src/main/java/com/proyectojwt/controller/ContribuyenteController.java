package com.proyectojwt.controller;

import com.proyectojwt.entity.Contribuyente;
import com.proyectojwt.entity.Tipo_contribuyente;
import com.proyectojwt.service.IContribuyenteService;
import com.proyectojwt.service.ITipo_contribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contribuyente")
@CrossOrigin("*")
public class ContribuyenteController {
    @Autowired
    private IContribuyenteService contribuyenteService;

    @Autowired
    private ITipo_contribuyenteService tipoContribuyenteService;


    @GetMapping("/lista-contribuyente")
    public ResponseEntity<List<Contribuyente>> listaContribuyente(){
        List<Contribuyente> lista = contribuyenteService.listarContribuyente();
        return  new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @PostMapping("/agregar-contribuyente")
    public ResponseEntity<Map<String,Object>> register(@Valid @RequestBody Contribuyente contribuyente){
        Map<String, Object> salida = new HashMap<>();

        Contribuyente contri = contribuyenteService.guardar(contribuyente);
        salida.put("mensaje","contribuyente registrado con exito");
        return new ResponseEntity<>(salida,HttpStatus.OK);
     }

    @GetMapping("/lista-tipo-contribuyente")
    public ResponseEntity<List<Tipo_contribuyente>> listaTipoContribuyente(){
        List<Tipo_contribuyente> lista = tipoContribuyenteService.listaTipo();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
