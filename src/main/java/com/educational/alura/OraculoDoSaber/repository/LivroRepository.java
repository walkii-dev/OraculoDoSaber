package com.educational.alura.OraculoDoSaber.repository;

import com.educational.alura.OraculoDoSaber.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository  <Livro, Long> {
    Optional<Livro> findByTitulo(String titulo);
}
