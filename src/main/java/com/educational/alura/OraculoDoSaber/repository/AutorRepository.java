package com.educational.alura.OraculoDoSaber.repository;

import com.educational.alura.OraculoDoSaber.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository <Autor,Long> {
    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :anoEscolhido AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :anoEscolhido)")
    List<Autor> encontrarAutoresVivosNoAno(@Param("anoEscolhido") Integer anoEscolhido);

    Optional<Autor>findByNomeContainingIgnoreCase(String nome);
}
