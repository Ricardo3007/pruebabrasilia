package com.example.pruebabrasilia.controllers;


import com.example.pruebabrasilia.entities.Usuario;
import com.example.pruebabrasilia.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    // Consulta de usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        return new ResponseEntity<>(_usuarioService.getUsuario(), HttpStatus.OK);
    }

    // COnsulta Usuarrio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Integer id) {
        return new ResponseEntity<>(_usuarioService.getUsuarioId(id), HttpStatus.OK);
    }

    // Guardar Usuario
    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        _usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    // Elmiminar Usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable Integer id) {
        return new ResponseEntity<>(_usuarioService.deleteUsuario(id), HttpStatus.OK);
    }

}
