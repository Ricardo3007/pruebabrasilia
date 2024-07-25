package com.example.pruebabrasilia.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;

    @Column(columnDefinition = "boolean default false")
    private boolean completa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UsuarioId", foreignKey = @ForeignKey(name = "FK_TAREA_USUARIO"))
    private Usuario Usuario;

    @Column(columnDefinition = "boolean default true")
    private Boolean estado = true;
}
