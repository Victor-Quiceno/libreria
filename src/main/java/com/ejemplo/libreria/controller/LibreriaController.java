package com.ejemplo.libreria.controller;

import com.ejemplo.libreria.model.Libros;
import com.ejemplo.libreria.service.I_ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libreria")
public class LibreriaController {

    // Esto es una inyección de dependencias
    private final I_ServicioLibro i_servicio;

    public LibreriaController(I_ServicioLibro i_servicio) {
        this.i_servicio = i_servicio;
    }

    @GetMapping("/todos")
    public List<Libros> obtenerTodos() {
        return i_servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerPorId(@PathVariable long id) {
        Optional<Libros> libro = i_servicio.obtenerPorId(id);

        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libros> crear(@RequestBody Libros libro) {
        i_servicio.guardar(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar (@PathVariable long id) {
        i_servicio.eliminaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
