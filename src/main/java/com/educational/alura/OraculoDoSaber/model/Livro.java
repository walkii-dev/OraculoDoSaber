package com.educational.alura.OraculoDoSaber.model;

import com.educational.alura.OraculoDoSaber.model.dto.AuxiliarDTO;
import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Column(nullable = false)
    private String idioma;

    private Integer numeroDownloads;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Livro(AuxiliarDTO auxiliar,Autor autor) {
        this.titulo = auxiliar.resultado().get(0).titulo();
        this.autor = autor;
        this.idioma = auxiliar.resultado().get(0).languages().get(0);
        this.numeroDownloads = auxiliar.resultado().get(0).numeroDownloads();
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "--------------------------------------------------------"+
                "\nNome do Livro: "+ titulo+
                "\nAutor: "+autor.getNome()+
                "\nIdioma: "+idioma+
                "\nNúmero de Downloads: "+numeroDownloads+
                "\n--------------------------------------------------------";
    }
}
