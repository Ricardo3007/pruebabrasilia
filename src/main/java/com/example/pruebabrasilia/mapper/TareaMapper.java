package com.example.pruebabrasilia.mapper;


import com.example.pruebabrasilia.dto.TareaUsuarioGetDTO;
import com.example.pruebabrasilia.entities.Tarea;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TareaMapper {

    private final ModelMapper modelMapper;

    public TareaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TareaUsuarioGetDTO ToDto(Tarea tarea) {
        return modelMapper.map(tarea, TareaUsuarioGetDTO.class);
    }

    public List<TareaUsuarioGetDTO> ToDtoList(List<Tarea> usuarioList) {
        return usuarioList.stream()
                .map(this::ToDto)
                .collect(Collectors.toList());
    }
}
