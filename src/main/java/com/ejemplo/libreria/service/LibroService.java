package com.ejemplo.libreria.service;

import org.springframework.stereotype.Service;

@Service
public class LibroService {

    public String buscaLibro (String titulo) {

        if ("El quijote".equalsIgnoreCase(titulo)){
            return "Libro encontrado";
        } else {
            return "Libro no encontrado";
        }

    }

}
