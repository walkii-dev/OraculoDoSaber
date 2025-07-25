package com.educational.alura.OraculoDoSaber.model;

import com.educational.alura.OraculoDoSaber.model.dto.AutorDTO;
import com.educational.alura.OraculoDoSaber.model.dto.AuxiliarDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Livro> livrosDoAutor = new ArrayList<>();

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
        livrosDoAutor.forEach(l->l.setAutor(this));
        this.livrosDoAutor = livrosDoAutor;
    }

    public Autor(AuxiliarDTO auxiliar) {
        this.nome = auxiliar.resultado().get(0).autor().get(0).nome();
        this.anoNascimento = auxiliar.resultado().get(0).autor().get(0).anoNascimento();
        this.anoFalecimento = auxiliar.resultado().get(0).autor().get(0).anoFalecimento();
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return "--------------------------------------------------------"+
                "\nAutor: "+nome+
                "\nAno de nascimento: "+anoNascimento+
                "\nAno de falecimento: "+anoFalecimento+
                "\nLivros do autor: "+livrosDoAutor.get(0).getTitulo()+
                "\n--------------------------------------------------------";
    }
}
