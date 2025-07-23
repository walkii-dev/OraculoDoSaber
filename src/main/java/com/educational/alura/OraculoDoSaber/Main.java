package com.educational.alura.OraculoDoSaber;

import com.educational.alura.OraculoDoSaber.model.Autor;
import com.educational.alura.OraculoDoSaber.model.Livro;
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

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    public Main (AutorRepository autorRepository,LivroRepository livroRepository){
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
                    listarLivrosBuscados();
                    break;
                case 3:
                    listarAutoresLivrosBuscados();
                    break;
                case 4:
                    listarAutoresVivosNoAno();
                    break;
                case 5:
                    livrosPorIdioma();
                    break;
                case 6:
                    buscarAutorListadoPorNome();
                    break;
                case 7:
                    buscarTop5MaisBaixados();
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

    public AuxiliarDTO getRespostaAPI(){
        System.out.println("Digite um dom casmurro para testar:");
        var busca = input.nextLine();
        var json = consumo.obterDadosAPI(busca);
//        System.out.println(json);
        AuxiliarDTO resposta = conversor.converterDados(json, AuxiliarDTO.class);
//        System.out.println(resposta);
        return resposta;
    }
    public void buscarLivroPeloTitulo(){
        AuxiliarDTO auxiliar = getRespostaAPI();

        var autor = new Autor(auxiliar);
        var livro = new Livro(auxiliar,autor);
        autorRepository.save(autor);
        livroRepository.save(livro);
        System.out.println(livro);
        System.out.println("tudo certo!");
    }

    public void listarLivrosBuscados(){
        livroRepository.findAll().forEach(System.out::println);
    }

    public void listarAutoresLivrosBuscados(){
        autorRepository.findAll().forEach(System.out::println);
    }

    public void listarAutoresVivosNoAno(){
        System.out.println("insira o ano que deseja procurar: ");
        var busca = input.nextInt();
        List<Autor> listaAutores = autorRepository.encontrarAutoresVivosNoAno(busca);
        listaAutores.forEach(System.out::println);

    }

    public void livrosPorIdioma(){
        System.out.println("insira o idioma que deseja procurar: ");
        var busca = input.nextLine();
        List<Livro> livrosPorIdioma = livroRepository.findByIdioma(busca);
        livrosPorIdioma.forEach(System.out::println);
    }

    public void buscarAutorListadoPorNome(){
        System.out.println("insira o nome do autor que deseja procurar: ");
        var busca = input.nextLine();
        Optional<Autor> autorPorNome = autorRepository.findByNomeContainingIgnoreCase(busca);
        if(autorPorNome.isPresent()){
            System.out.println(autorPorNome);
        }
        else{
            System.out.println("não encontrado.");
        }

    }

    public void buscarTop5MaisBaixados(){
        List<Livro> listaTop3 = livroRepository.findTop3ByOrderByNumeroDownloadsDesc();
        listaTop3.stream().forEach(System.out::println);
    }





}
