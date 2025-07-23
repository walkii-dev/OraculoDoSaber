package com.educational.alura.OraculoDoSaber.repository;

import com.educational.alura.OraculoDoSaber.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor,Long> {
}
