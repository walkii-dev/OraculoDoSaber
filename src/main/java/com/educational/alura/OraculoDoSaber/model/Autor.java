package com.educational.alura.OraculoDoSaber.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @Transient
    private List<Livro> livrosDoAutor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivrosDoAutor() {
        return livrosDoAutor;
    }

    public void setLivrosDoAutor(List<Livro> livrosDoAutor) {
        this.livrosDoAutor = livrosDoAutor;
    }

    public Autor(Long id, String nome, Integer anoNascimento, Integer anoFalecimento, List<Livro> livrosDoAutor) {
        this.id = id;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
        this.livrosDoAutor = livrosDoAutor;
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoFalecimento=" + anoFalecimento +
                ", livrosDoAutor=" + livrosDoAutor +
                '}';
    }
}
