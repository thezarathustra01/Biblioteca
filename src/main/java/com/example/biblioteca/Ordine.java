package com.example.biblioteca;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import com.example.biblioteca.model.Libro;

public class Ordine {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @NotBlank
     private long idOrdine;
     @NotBlank
     private long idLibro;
     @Column(nullable = false)
     private int ncopie;
     private Libro libro;
     public long getIdOrdine(){
        return idOrdine;
     }
     public void SetIdOrdine(long IdOrdine) {
    this.idOrdine = IdOrdine;
     }
    public long getIdlibro(){
        return libro.getIdlibro();
    }
    public int getNcopie(){
        return ncopie;
    }
    public void setNcopie(int ncopie) {
        libro.setNcopie(libro.getNcopie()-ncopie);
        this.ncopie = ncopie;
    }
    public Libro getLibro(){
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
