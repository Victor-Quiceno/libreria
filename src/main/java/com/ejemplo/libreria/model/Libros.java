package com.ejemplo.libreria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Libros implements Cloneable {
    private Long idLibro;
    private String autor;
    private String titulo;
    private LocalDate fechaPublicacion;

    @Override
    public Libros clone() {
        try {
            return (Libros) super.clone();
        } catch (CloneNotSupportedException ERROR) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Libros [idLibro=" + idLibro + ", autor=" + autor + ", titulo=" + titulo + ", fechaPublicacion="
                + fechaPublicacion + "]";
    }

}
