package app;

import intermediario.Services;
import modelos.Cartoes;
import modelos.Listas;
import modelos.Quadros;
import modelos.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Services intermediario = new Services();
        while(true){
            if (!intermediario.isLogado()){
                System.out.println("\t\t****Trello****\n" +
                                "1 - Log in\n" +
                                "2 - Sign in\n" +
                                "0 - Exit");
                int opcao = scanner.nextInt();
                if (opcao == 0){
                    System.out.println("Saindo...");
                    break;
                }else if(opcao == 1){
                    System.out.println("Email: ");
                    String email = scanner.next();
                    System.out.println("Senha: ");
                    String senha = scanner.next();
                    System.out.println("Digite a senha novamente: ");
                    String senha_confirmacao = scanner.next();
                    if (senha.equals(senha_confirmacao)){
                        if (intermediario.logar(email, senha)){
                            System.out.println("Sucesso!!");
                            intermediario.setLogado(true);
                        }else {
                            System.out.println("Usuário e/ou senha errada(s)");
                        }
                    }
                }else if(opcao == 2){
                    System.out.println("Nome: ");
                    String nome = scanner.next();
                    System.out.println("Email: ");
                    String email = scanner.next();
                    System.out.println("Senha: ");
                    String senha = scanner.next();
                    System.out.println("Digite a senha novamente: ");
                    String senha_confirmacao = scanner.next();
                    if (intermediario.adicionarUsuario(nome, email, senha)){
                        System.out.println("Usuário criado.");
                    }else {
                        System.out.println("Usuário já existente!");
                    }
                }else {
                    System.out.println("Digite uma opção válida!!");
                }
            }else {
                System.out.println("1 - Criar Quadro\n" +
                                   "2 - Usar Quadro\n" +
                                   "0 - Deslogar");
                int opcao = scanner.nextInt();
                if (opcao == 0){
                    System.out.println("Deslogando..");
                    intermediario.setLogado(false);
                }else if(opcao == 1){
                    System.out.println("Título: ");
                    String titulo = scanner.next();
                    if (intermediario.adicionarQuadro(titulo)){
                        System.out.println("Quadro adicionado.");
                    }else {
                        System.out.println("Falhou XDDDD !");
                    }
                }else if(opcao == 2){
                    System.out.println("Título: ");
                    String titulo = scanner.next();
                    System.out.println("Qual quadro adicionar? ");
                    String quadro = scanner.next();
                    if (intermediario.adicionarLista(quadro, titulo)){
                        System.out.println("Lista Adicionado!");
                    }else {
                        System.out.println("Falhou pô :(");
                    }
                }/*else if(opcao == 3){
                    System.out.println("Titulo quadro:");
                    String quadro = scanner.next();
                    System.out.println("Titulo lista");
                    String lista = scanner.next();
                    System.out.println("Titulo cartao: ");
                    String cartao = scanner.next();
                    if (intermediario.adicionarCartao(quadro, cartao, lista)){
                        System.out.println("Cartao adicionado!");
                    }else {
                        System.out.println("Falhou :D !!");
                    }

                }*/else if(opcao == 666){
                   ArrayList<Quadros> quadros = intermediario.pegarQuadros();
                   for (Quadros quadro: quadros){
                       System.out.println(quadro.getTitulo());
                       for (Listas lista : quadro.getListas()){
                           System.out.println(lista.getNome());
                           for (Cartoes cartao : lista.getCartoes())
                               System.out.println(cartao.getTitulo());
                       }
                   }
                }

            }
        }
    }
}
