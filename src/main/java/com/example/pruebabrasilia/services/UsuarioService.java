package com.example.pruebabrasilia.services;


import com.example.pruebabrasilia.entities.Usuario;
import com.example.pruebabrasilia.exception.DataNotFoundException;
import com.example.pruebabrasilia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    public UsuarioService(){}

    public void saveUsuario(Usuario usuario){
        _usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuario(){
//        return _usuarioRepository.findAll();
        List<Usuario> lista = _usuarioRepository.findAll();
        return lista;
    }

    public boolean deleteUsuario(Integer id) {
        Usuario usuario = getUsuarioById(id);
        _usuarioRepository.deleteById(usuario.getId());
        return true;
    }

    public Usuario getUsuarioId(Integer id) {
        Usuario usuario = getUsuarioById(id);
        return usuario;
    }

    private Usuario getUsuarioById(Integer id) {
        Optional<Usuario> usuario = _usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new DataNotFoundException("Id de usuario no encontrado");
        }
        return usuario.get();
    }

}
