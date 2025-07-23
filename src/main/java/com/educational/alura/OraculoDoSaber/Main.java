package com.educational.alura.OraculoDoSaber;

import com.educational.alura.OraculoDoSaber.model.Autor;
import com.educational.alura.OraculoDoSaber.model.Livro;
import com.educational.alura.OraculoDoSaber.model.dto.AutorDTO;
import com.educational.alura.OraculoDoSaber.model.dto.AuxiliarDTO;
import com.educational.alura.OraculoDoSaber.model.dto.LivroDTO;
import com.educational.alura.OraculoDoSaber.repository.AutorRepository;
import com.educational.alura.OraculoDoSaber.repository.LivroRepository;
import com.educational.alura.OraculoDoSaber.service.ConsumoAPI;
import com.educational.alura.OraculoDoSaber.service.ConversaoDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private ConsumoAPI consumo = new ConsumoAPI();
    private ConversaoDados conversor = new ConversaoDados();
    private Scanner input = new Scanner(System.in);

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Main(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    public void mainMenu(){

        String opcoesMenu = """
                            
                            1 - Buscar Livro pelo Título
                            2 - Listar Livros Buscados
                            3 - Listar Autores dos livros Buscados
                            4 - Listar Autores vivos em um determinado ano
                            5 - Listar Livros buscados em um idioma
                            6 - Buscar Autor registrado pelo Nome
                            7 - Buscar Livros mais baixados
                            
                            
                            0 - Sair
                            
                            """;

        var option = -1;
        while (option != 0){
            System.out.println(opcoesMenu);
            option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    //listarLivrosBuscados();
                    break;
                case 3:
                    //listarAutoresLivrosBuscados();
                    break;
                case 4:
                    //listarAutoresVivosNoAno();
                    break;
                case 5:
                    //livrosPorIdioma();
                    break;
                case 6:
                    //buscarAutorListadoPorNome();
                    break;
                case 7:
                    //buscarTop5MaisBaixados();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public AuxiliarDTO getInfo(){
        System.out.println("Digite um dom casmurro para testar:");
        var busca = input.nextLine();
        var json = consumo.obterDadosAPI(busca);
//        System.out.println(json);
        AuxiliarDTO auxiliar = conversor.converterDados(json, AuxiliarDTO.class);
        System.out.println(auxiliar);
        return auxiliar;
    }
    public void buscarLivroPeloTitulo(){

//        AuxiliarDTO auxiliar = getInfo();
//
//        Autor autor = new Autor(auxiliar);
//        Livro livro = new Livro(auxiliar,autor);
//
//        System.out.println(autor);
//        System.out.println(livro);
//
//        autorRepository.save(autor);
//        livroRepository.save(livro);

//        AuxiliarDTO auxiliar = getInfo();
//        LivroDTO livroDTO = auxiliar.resultado().get(0);
//        AutorDTO autorDTO = livroDTO.autor().get(0);
//
//        // Verifica se o autor já existe
//        Autor autor = autorRepository.findByNome(autorDTO.nome())
//                .orElseGet(() -> autorRepository.save(new Autor(auxiliar)));
//
//        // Cria o livro com o autor persistido
//        Livro livro = new Livro(auxiliar);
//        livro.setAutor(autor);
//
//        // Salva o livro
//        livroRepository.save(livro);
//
//        System.out.println("Autor salvo: " + autor);
//        System.out.println("Livro salvo: " + livro);

        AuxiliarDTO auxiliar = getInfo();
        String titulo = auxiliar.resultado().get(0).titulo();

        Optional<Livro> livroExistente = livroRepository.findByTitulo(titulo);

        if (livroExistente.isEmpty()) {
            AutorDTO autorDTO = auxiliar.resultado().get(0).autor().get(0);
            Autor autor = autorRepository.findByNome(autorDTO.nome())
                    .orElseGet(() -> autorRepository.save(new Autor(auxiliar)));

            Livro livro = new Livro(auxiliar);
            livro.setAutor(autor);
            livroRepository.save(livro);
            System.out.println("Livro salvo com sucesso!");
        } else {
            System.out.println("Livro já existe no banco: " + livroExistente.get());
        }


    }

}
