package com.educational.alura.OraculoDoSaber.repository;

import com.educational.alura.OraculoDoSaber.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LivroRepository extends JpaRepository  <Livro, Long> {
    List<Livro> findByIdioma(String idioma);

    List<Livro> findTop3ByOrderByNumeroDownloadsDesc();
}
