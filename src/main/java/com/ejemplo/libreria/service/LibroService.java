package com.ejemplo.libreria.service;

import com.ejemplo.libreria.RepoLibros.I_RepoLibros;
import com.ejemplo.libreria.model.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements I_ServicioLibro {

    private final I_RepoLibros i_repo;

    @Autowired
    public LibroService(I_RepoLibros i_repo) {
        this.i_repo = i_repo;
    }

    @Override
    public List<Libros> obtenerTodos() {
        return i_repo.findAll();
    }

    @Override
    public Optional<Libros> obtenerPorId(long id) {
        return i_repo.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        i_repo.save(libro);
        return libro;
    }

    @Override
    public void eliminaPorId(long id) {
        i_repo.deleteById(id);
    }

    @Override
    public String buscaLibroPorTitulo(String titulo) {
        boolean encontrado = i_repo.findAll().stream()
                .anyMatch(libros -> libros.getTitulo()
                != null && libros.getTitulo().equalsIgnoreCase(titulo));

        // El ? sirve para el if y el : para el else
        return encontrado ? "Libro encontrado: " + titulo : "Libro no encontrado: " + titulo;
    }

}
