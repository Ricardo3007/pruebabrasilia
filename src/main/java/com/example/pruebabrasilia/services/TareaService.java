package com.example.pruebabrasilia.services;


import com.example.pruebabrasilia.dto.TareaUsuarioGetDTO;
import com.example.pruebabrasilia.entities.Tarea;
import com.example.pruebabrasilia.entities.Usuario;
import com.example.pruebabrasilia.exception.DataNotFoundException;
import com.example.pruebabrasilia.mapper.TareaMapper;
import com.example.pruebabrasilia.repositories.TareaRepository;
import com.example.pruebabrasilia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaService {
    @Autowired
    private TareaRepository _tareaRepository;

    @Autowired
    private TareaMapper _tareaMapper;

    @Autowired
    private UsuarioRepository _usuarioRepository;


    public TareaService(){}

    public Tarea saveTarea(Integer usuarioId, Tarea tarea) {
        Usuario usuario = getUsuarioById(usuarioId);
        tarea.setUsuario(usuario);

        return _tareaRepository.save(tarea);
    }

    public List<TareaUsuarioGetDTO> getTareaUsuarioId(Integer usuarioId) {
        Usuario usuario = getUsuarioById(usuarioId);
        return _tareaMapper.ToDtoList(usuario.getTareas());
    }



    public Tarea updateEstadoTarea(Integer tareaId) {
        Tarea tarea = getTareaById(tareaId);
        tarea.setCompleta(true);
        return tarea;
    }


    public Boolean deleteTarea(Integer tareaId) {
        Tarea tarea = getTareaById(tareaId);
//        if (!tarea.getUsuario().getId().equals(usuarioId)) {
//            throw new RecursoNoEncontrado(AppConstants.TAREA_NO_USUARIO);
//        }
        _tareaRepository.delete(tarea);
        return true;
    }



    private Tarea getTareaById(Integer id) {
        Optional<Tarea> tarea = _tareaRepository.findById(id);
        if (tarea.isEmpty()) {
            throw new DataNotFoundException("Id de tarea no encontrado.");
        }
        return tarea.get();
    }


    private Usuario getUsuarioById(Integer id) {
        Optional<Usuario> usuario = _usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new DataNotFoundException("Id de usuario no encontrado");
        }
        return usuario.get();
    }

}
