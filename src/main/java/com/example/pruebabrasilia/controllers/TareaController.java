package com.example.pruebabrasilia.controllers;


import com.example.pruebabrasilia.dto.TareaUsuarioGetDTO;
import com.example.pruebabrasilia.entities.Tarea;
import com.example.pruebabrasilia.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tarea")
//@RequestMapping("api/{usuarioId}/tarea")
//
public class TareaController {

    @Autowired
    private TareaService _tareaService;

    @PostMapping("/{usuarioId}")
    public ResponseEntity<Tarea> saveTarea(@PathVariable Integer usuarioId, @RequestBody Tarea tarea) {
        return new ResponseEntity<>(_tareaService.saveTarea(usuarioId, tarea), HttpStatus.OK);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<TareaUsuarioGetDTO>> getTareaUsuarioId(@PathVariable Integer usuarioId) {
        return new ResponseEntity<>(_tareaService.getTareaUsuarioId(usuarioId), HttpStatus.OK);
    }

    @PutMapping("/{tareaId}")
    public ResponseEntity<Tarea> updateEstadoTarea(@PathVariable Integer tareaId) {
        return new ResponseEntity<>(_tareaService.updateEstadoTarea(tareaId), HttpStatus.OK);
    }

    @DeleteMapping("/{tareaId}")
    public ResponseEntity<Boolean> deleteTarea(@PathVariable Integer tareaId) {
        return new ResponseEntity<>(_tareaService.deleteTarea(tareaId), HttpStatus.OK);
    }

}
