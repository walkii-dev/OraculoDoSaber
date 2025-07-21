package com.educational.alura.OraculoDoSaber.service;

import com.educational.alura.OraculoDoSaber.model.dto.AutorDTO;
import com.educational.alura.OraculoDoSaber.model.dto.LivroDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConversaoDados implements InterfaceConversaoDados{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <G> G converterDados(String json, Class<G> classe) {
        try {
            return mapper.readValue(json,classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public <G> List<G> converterListaDados(String json, Class<G> classe){
        CollectionType lista = mapper.getTypeFactory().constructCollectionType(List.class,classe);
        try{
            return mapper.readValue(json,lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
