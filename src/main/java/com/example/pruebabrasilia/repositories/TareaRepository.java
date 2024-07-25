package com.example.pruebabrasilia.repositories;

import com.example.pruebabrasilia.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
