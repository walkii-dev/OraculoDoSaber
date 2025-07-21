package com.educational.alura.OraculoDoSaber.service;

import java.util.List;

public interface InterfaceConversaoDados {
    <G> G converterDados(String json,Class<G> classe);

    <G> List<G> converterListaDados(String json, Class<G> classe);

}
