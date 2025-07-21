package com.educational.alura.OraculoDoSaber;

import com.educational.alura.OraculoDoSaber.model.Livro;
import com.educational.alura.OraculoDoSaber.model.dto.AuxiliarDTO;
import com.educational.alura.OraculoDoSaber.model.dto.LivroDTO;
import com.educational.alura.OraculoDoSaber.service.ConsumoAPI;
import com.educational.alura.OraculoDoSaber.service.ConversaoDados;

import java.util.List;
import java.util.Scanner;

public class Main {

    private ConsumoAPI consumo = new ConsumoAPI();
    private ConversaoDados conversor = new ConversaoDados();

    public void mainMenu(){
        var input = new Scanner(System.in);

        System.out.println("Digite um dom casmurro para testar:");
        var busca = input.nextLine();

        var json = consumo.obterDadosAPI(busca);
        System.out.println(json);

        AuxiliarDTO a = conversor.converterDados(json, AuxiliarDTO.class);
        System.out.println(a);



    }
}
