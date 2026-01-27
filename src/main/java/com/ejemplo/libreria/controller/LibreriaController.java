package com.ejemplo.libreria.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.libreria.service.LibroService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/libros")
public class LibreriaController {

    // Esto es una inyección de dependencias
    private final LibroService serviceLibro;

    public LibreriaController(LibroService serviceLibro) {
        this.serviceLibro = serviceLibro;
    }

    @GetMapping("/{titulo}")
    public String DameLibro(@PathVariable String titulo) {
        return serviceLibro.buscaLibro(titulo);
    }

}
