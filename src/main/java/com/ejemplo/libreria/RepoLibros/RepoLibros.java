package com.ejemplo.libreria.RepoLibros;

import com.ejemplo.libreria.model.Libros;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepoLibros implements I_RepoLibros {

    // Aquí creamos una lista inmutable de libros
    private final List<Libros> libros = new ArrayList<>();

    public RepoLibros() {
        libros.add(new Libros(1L, "Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 11, 16)));
        libros.add(new Libros(2L, "Gabriel García Márquez", "Cien Años de Soledad", LocalDate.of(1967, 5, 30)));
        libros.add(new Libros(3L, "J.K. Rowling", "Harry Potter y la Piedra Filosofal", LocalDate.of(1997, 6, 26)));
        libros.add(new Libros(4L, "George Orwell", "1984", LocalDate.of(1949, 6, 8)));
        libros.add(new Libros(5L, "F. Scott Fitzgerald", "El Gran Gatsby", LocalDate.of(1925, 4, 10)));
        libros.add(new Libros(6L, "Jane Austen", "Orgullo y Prejuicio", LocalDate.of(1813, 1, 28)));
    }

    // Método para obtener todos los libros
    @Override
    public List<Libros> findAll() {
        return libros;
    }

    // Método para buscar un libro por su ID
    @Override
    public Optional<Libros> findById(long idLibro) {
        return libros.stream()
                .filter(libros1 -> libros1.getIdLibro() == idLibro)
                .findFirst();
    }

    @Override
    public void save(Libros libro) {
        findById(libro.getIdLibro()).ifPresent(libros::remove);
        libros.add(libro);
    }

    @Override
    public void deleteById(long id) {
        findById(id).ifPresent(libros::remove);
    }

}
