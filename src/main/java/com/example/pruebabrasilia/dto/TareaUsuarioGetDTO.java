package com.example.pruebabrasilia.dto;


import lombok.Data;

import java.util.Date;

@Data
public class TareaUsuarioGetDTO {

    private Integer Id;
    private String Titulo;
    private String Descripcion;
    private boolean Completa;

}
