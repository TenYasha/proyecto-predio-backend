package com.proyectojwt.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.proyectojwt.entity.Rol;
import com.proyectojwt.entity.Usuario;
import com.proyectojwt.security.UsuarioDetails;
import com.proyectojwt.service.IRolService;
import com.proyectojwt.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://10.4.1.6:8180")
public class UsuarioController {

    @Autowired
    IUsuarioService ususervice;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioDetails userDetailsService;

    @Autowired
    IRolService rolservice;

    //Rol
    @GetMapping("/lista-rol")
    public ResponseEntity<List<Rol>> listaRol() {
        List<Rol> lista = rolservice.listRol();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //Usuario
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> listarUsuarioo() {
        List<Usuario> lista = ususervice.listaUsuario();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal) {
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());

    }

    @GetMapping("{id}")
    public Usuario buscarCiudad(@PathVariable("id") String cod) {
        Usuario ciu = ususervice.buscarUsuario(cod);

        return ciu;
    }

    @PutMapping("/actualiza-estado")
    public ResponseEntity<Usuario> actualizarEstado(@Valid @RequestBody Usuario usu) {
        ususervice.guardar(usu);

        return new ResponseEntity<>(usu, HttpStatus.OK);
    }

    @PutMapping("/actualiza")
    public ResponseEntity<Usuario> actualizarUsuario(@Valid @RequestBody Usuario usu) {
        Usuario user = ususervice.buscarUsuario(String.valueOf(usu.getId_usuario()));
        if (usu.getPassword() != user.getPassword()) {
            usu.setPassword(passwordEncoder.encode(usu.getPassword()));
            ususervice.guardar(usu);
        } else {
            ususervice.guardar(usu);
        }
        return new ResponseEntity<>(usu, HttpStatus.OK);
    }
    @PostMapping("/registrar")
    public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody Usuario usu) {
        Map<String, Object> salida = new HashMap<>();
        Usuario user = ususervice.buscarnameuser(usu.getUsername());

        if (user != null) {
            salida.put("mensaje", "El nombre de usuario ya existe en BD");
            return new ResponseEntity<>(salida, HttpStatus.OK);
        }

        // Registro de usuario sin asignar roles directamente
        usu.setId_usuario(0);
        usu.setPassword(passwordEncoder.encode(usu.getPassword()));

        // Asignar los roles enviados desde el frontend al usuario
        // Asumiendo que los nombres de los roles se encuentran en el campo roles del objeto Usuario
        // y que estos nombres coinciden con los roles existentes en la base de datos

        // Obtener los roles existentes en la base de datos por sus nombre

        // Guardar el usuario en la base de datos
        Usuario empl = ususervice.guardar(usu);
        salida.put("mensaje", "Usuario registrado exitosamente");

        return new ResponseEntity<>(salida, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Integer id) {
        try {
            ususervice.eliminarUsuario(id);
            // Crear un objeto JSON con el mensaje
            String mensaje = "Usuario eliminado con éxito";
            return ResponseEntity.ok().body("{\"mensaje\": \"" + mensaje + "\"}");
        } catch (Exception e) {
            // Manejar errores y devolver una respuesta apropiada en caso de error
            return ResponseEntity.status(500).body("{\"error\": \"Error al eliminar el usuario\"}");
        }
    }

}