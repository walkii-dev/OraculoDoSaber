package com.educational.alura.OraculoDoSaber.model;

import com.educational.alura.OraculoDoSaber.model.dto.AutorDTO;
import com.educational.alura.OraculoDoSaber.model.dto.AuxiliarDTO;
import com.educational.alura.OraculoDoSaber.model.dto.LivroDTO;
import com.educational.alura.OraculoDoSaber.repository.LivroRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    private String idioma;
    private Integer numeroDownloads;



    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public Livro(AuxiliarDTO auxiliar) {
        this.titulo = auxiliar.resultado().get(0).titulo();
        this.autor = new Autor(auxiliar);
        this.idioma = auxiliar.resultado().get(0).languages().get(0);
        this.numeroDownloads = auxiliar.resultado().get(0).numeroDownloads();
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor.getNome() +
                ", idioma='" + idioma + '\'' +
                ", numeroDownloads=" + numeroDownloads +
                '}';
    }
}
