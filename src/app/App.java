package app;

import intermediario.Services;
import modelos.Quadros;
import modelos.Usuarios;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Services intermediario = new Services();
        boolean logado = false;
        while(true){
            if (!logado){
                System.out.println("\t\t****Trello****");
                System.out.println("1 - Log in");
                System.out.println("2 - Sign in");
                System.out.println("0 - Exit");
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
                            logado = true;
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
                    if (intermediario.adicionarUsuario(nome, email, senha)){
                        System.out.println("Usuário criado.");
                    }else {
                        System.out.println("Usuário já existente!");
                    }
                }else {
                    System.out.println("Digite uma opção válida!!");
                }
            }else {
                System.out.println("1 - Criar Quadro");
                System.out.println("2 - Adicionar lista em um quadro");
                System.out.println("3 - Adicionar cartao a uma lista");
                System.out.println("0 - Deslogar");
                int opcao = scanner.nextInt();
                if (opcao == 0){
                    System.out.println("Deslogando..");
                    logado = false;
                }else if(opcao == 1){
                    System.out.println("Título: ");
                    String titulo = scanner.next();
                    intermediario.adicionarQuadro(titulo);
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
                }else if(opcao == 3){
                    System.out.println("Titulo quadro:");
                    String quadro = scanner.next();
                    System.out.println("Titulo cartao: ");
                    String cartao = scanner.next();
                    System.out.println("Titulo lista");
                    String lista = scanner.next();

                }

            }
        }
    }
}
