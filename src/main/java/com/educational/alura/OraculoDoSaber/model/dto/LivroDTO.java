package com.educational.alura.OraculoDoSaber.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(@JsonAlias("title")String titulo,
                       @JsonAlias("authors") List<AutorDTO> autor,
                       @JsonAlias("languages")List<String> languages,
                       @JsonAlias("download_count")Integer numeroDownloads){
}
