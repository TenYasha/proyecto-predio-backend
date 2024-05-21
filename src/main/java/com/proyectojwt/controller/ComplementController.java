package com.proyectojwt.controller;

import com.proyectojwt.entity.Condicion_propiedad;
import com.proyectojwt.entity.Contribuyente;
import com.proyectojwt.entity.Exonero;
import com.proyectojwt.entity.Situacion;
import com.proyectojwt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Complementos")
@CrossOrigin("*")
public class ComplementController {

    // Servicios
    @Autowired
    private ICondicion_propiedadService iCondicionPropiedadService;
    @Autowired
    private IExoneroService iExoneroService;
    @Autowired
    private ISituacionService iSituacionService;
    @Autowired
    private ITipo_edificacionService iTipoEdificacionService;
    @Autowired
    private ITipo_propiedadService iTipoPropiedadService;

    // Condicion_propiedad
    @GetMapping("/lista-condicion-propiedad")
    public ResponseEntity<List<Condicion_propiedad>> listaCondicionPropiedad() {
        List<Condicion_propiedad> lista = iCondicionPropiedadService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/agregar-condicion-propiedad")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody Condicion_propiedad condicionPropiedad) {
        Map<String, Object> salida = new HashMap<>();
        Condicion_propiedad condicion = iCondicionPropiedadService.guardar(condicionPropiedad);
        salida.put("mensaje", "condicion de la propiedad registrada correctamente");
        return new ResponseEntity<>(salida, HttpStatus.OK);

    }

    @PutMapping("/actualizar-condicion-propiedad")
    public ResponseEntity<Condicion_propiedad> actualizarCondicion(@Valid @RequestBody Condicion_propiedad condicionPropiedad) {
        iCondicionPropiedadService.guardar(condicionPropiedad);
        return new ResponseEntity<>(condicionPropiedad, HttpStatus.OK);
    }

    @DeleteMapping("/borrar-condicion/{id}")
    public ResponseEntity<Object> eliminarCondicion(@PathVariable Integer id) {
        try {
            iCondicionPropiedadService.eliminar(id);
            String mensaje = "Condicion eliminada con exito";
            return ResponseEntity.ok().body("{\"mesaje\":\"" + mensaje + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error al eliminar la condicion\"}");
        }

    }

    //Exonero
    @GetMapping("/listar-Exonero")
    public ResponseEntity<List<Exonero>> listaExonero() {
        List<Exonero> lista = iExoneroService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/agregar-Exonero")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody Exonero exonero) {
        Map<String, Object> salida = new HashMap<>();
        Exonero exoneroV = iExoneroService.guardar(exonero);
        salida.put("mensaje", "el exonerado de la propiedad se registro correctamente");
        return new ResponseEntity<>(salida, HttpStatus.OK);
    }

    @PutMapping("/actualizar-exonero")
    public ResponseEntity<Exonero> actualizarExonero(@Valid @RequestBody Exonero exonero) {
        iExoneroService.guardar(exonero);
        return new ResponseEntity<>(exonero, HttpStatus.OK);
    }

    @DeleteMapping("/borrar-exonero/{id}")
    public ResponseEntity<Object> eliminarExonero(@PathVariable Integer id) {

        try {
            iExoneroService.eliminar(id);
            String mensaje = "Exoneracion eliminada correctamente";
            return ResponseEntity.ok().body("{\"mesaje\":\"" + mensaje + "\"}");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error al eliminar la exoneracion\"}");
        }
    }

    //Situacion
    @GetMapping("/listar-situacion")
    public ResponseEntity<List<Situacion>> listaSituacion() {
        List<Situacion> lista = iSituacionService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/agregar-situacion")
    public ResponseEntity<Map<String, Object>> registrarSituacion(@Valid @RequestBody Situacion situacion) {
        Map<String, Object> salida = new HashMap<>();
        Situacion situacionV = iSituacionService.guardar(situacion);
        salida.put("mensaje", "situacion de la propiedad registrada correctamente");
        return new ResponseEntity<>(salida, HttpStatus.OK);

    }

    @PutMapping("/actulizar-situacion")
    public ResponseEntity<Situacion> actualizarSituacion(@Valid @RequestBody Situacion situacion){
        return null;
    }


}
