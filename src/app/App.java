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
            if (intermediario.getUsuariologado() == null){
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
            }else if(intermediario.getCartaoEmUso() != null){
                System.out.println("1 - Criar Comentário\n" +
                                   "2 - Adicionar Etiqueta\n" +
                                   "3 -Mostrar comentario\n" +
                                   "4 - Mostrar etiquetas\n" +
                                   "0 - Sair do cartao");

            }else if(intermediario.getListaEmUso()!=null){
                System.out.println("1 - Criar Cartao\n" +
                                   "2 - Usar Cartao\n" +
                                   "3 -Mostrar Cartoes\n" +
                                   "0 - Sair da lista");

            }else if(intermediario.getQuadroEmUso() != null){
                System.out.println("1 - Criar Lista\n" +
                                   "2 - Usar Lista\n" +
                                   "3 -Mostrar listas\n" +
                                   "0 - Sair do quadro");

            }else {
                System.out.println("1 - Criar Quadro\n" +
                                   "2 - Usar Quadro\n" +
                                   "3 - Listar\n" +
                                   "0 - Deslogar");
                int opcao = scanner.nextInt();
                if (opcao == 0){
                    System.out.println("Deslogando..");
                    intermediario.deslogar();
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
                    if (intermediario.selecionarQuadro(titulo)){
                        System.out.println("Quadro selecionado.");
                    }else {
                        System.out.println("Falhou XDDDD !");
                    }

                }else if(opcao == 666){
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
