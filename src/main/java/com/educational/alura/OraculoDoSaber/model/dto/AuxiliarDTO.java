package com.educational.alura.OraculoDoSaber.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record AuxiliarDTO(@JsonAlias("results")List<LivroDTO> resultado){
}
