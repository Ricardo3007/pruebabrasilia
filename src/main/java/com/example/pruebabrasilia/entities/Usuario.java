package com.example.pruebabrasilia.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 100)
    private String nombre;

    @Column(unique = true, length = 200, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private Boolean estado = true;

    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> Tareas = new ArrayList<>();

}
