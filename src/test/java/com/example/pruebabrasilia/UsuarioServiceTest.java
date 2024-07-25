package com.example.pruebabrasilia;


import com.example.pruebabrasilia.entities.Usuario;
import com.example.pruebabrasilia.exception.DataNotFoundException;
import com.example.pruebabrasilia.repositories.UsuarioRepository;
import com.example.pruebabrasilia.services.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsuarioId() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Prueba");
        usuario.setEmail("Prueba@gmail.com");
        usuario.setPassword("123456");

        // Configura el comportamiento del repositorio simulado
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        // Llama al método del servicio
        Usuario result = usuarioService.getUsuarioId(1);

        // Verifica los resultados
        assertEquals(1, result.getId());
        assertEquals("Prueba", result.getNombre());
        assertEquals("Prueba@gmail.com", result.getEmail());
    }

    @Test
    public void testGetUsuarioIdNotFound() {
        Integer nonExistentId = 999;

        // Verifica que se lance la excepción correcta
        Assertions.assertThrows(DataNotFoundException.class, () -> {
            usuarioService.getUsuarioId(nonExistentId);
        });
    }
}
