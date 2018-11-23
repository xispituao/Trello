package app;

import intermediario.Services;
import modelos.Cartoes;
import modelos.Listas;
import modelos.Quadros;

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
                    if (intermediario.logar(email, senha)){
                        System.out.println("Sucesso!!");
                    }else {
                        System.out.println("Usuário e/ou senha errada(s)");
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
                    if (senha.equals(senha_confirmacao)){
                        if (intermediario.adicionarUsuario(nome, email, senha)){
                            System.out.println("Usuário criado.");
                        }else {
                            System.out.println("Usuário já existente!");
                        }
                    }

                }else {
                    System.out.println("Digite uma opção válida!!");
                }
            }else if(intermediario.getCartaoEmUso() != null){
                System.out.println("1 - Criar Comentário\n" +
                        "2 - Adicionar Etiqueta\n" +
                        "3 - Mostrar comentario\n" +
                        "4 - Mostrar etiquetas\n" +
                        "0 - Sair do cartao");

            }else if(intermediario.getListaEmUso()!=null){
                System.out.println("1 - Mover lista\n" +
                        "2 - Arquivar lista\n" +
                        "3 - Apagar lista\n" +
                        "4 - Criar Cartao\n" +
                        "5 - Usar Cartao\n" +
                        "0 - Sair da lista");
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1:
                        System.out.println("Nova posicao?:");
                        int posicao = scanner.nextInt();
                        if (intermediario.moverLista(posicao)){
                            System.out.println("Movida!");
                        }else {
                            System.out.println("Escolha uma posicao válida!");
                        }
                        break;
                    case 2:
                        intermediario.arquivarLista();
                        System.out.println("Arquivado!");
                        break;
                    case 3:
                        System.out.println("Tem certeza?\n1 - Sim\n2 - nao\n");
                        int confimacao = scanner.nextInt();
                        switch (confimacao){
                            case 1:
                                if (intermediario.deletarLista()){
                                    System.out.println("Lista deletada!");
                                }else {
                                    System.out.println("Lista precisa esta arquivada antes!");
                                }
                                break;
                                default:
                                    System.out.println("Escolha uma das opcoes validas!");
                        }
                        break;
                    case 0:
                        intermediario.sairDaLista();
                        System.out.println("Saindo da lista...");
                        break;
                        default:
                            System.out.println("Escolha uma das opcoes validas!");
                }


            }else if(intermediario.getQuadroEmUso() != null){
                System.out.println("1 - Favoritar quadro\n" +
                        "2 - Criar lista\n" +
                        "3 - Usar lista\n" +
                        "0 - Sair do quadro");
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1:
                        intermediario.favoritarQuadro();
                        break;
                    case 2:
                        System.out.println("Titulo: ");
                        String titulo = scanner.next();
                        if (intermediario.adicionarLista(titulo)){
                            System.out.println("Lista adicionada!");
                        }else{
                            System.out.println("Lista já existente!");
                        }
                        break;
                    case 3:
                        System.out.println("Titulo: ");
                        titulo = scanner.next();
                        if (intermediario.selecionarLista(titulo)){
                            System.out.println("Lista selecionada!");
                        }else {
                            System.out.println("Lista não existe!");
                        }
                        break;
                    case 0:
                        System.out.println("Saindo do quadro...");
                        intermediario.sairDoQuadro();
                        break;

                        default:
                            System.out.println("Escolha umas das opcoes validas!!");


                }

            }else {
                System.out.println("1 - Criar Quadro\n" +
                        "2 - Usar Quadro\n" +
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
                            System.out.println(lista.getTitulo());
                            for (Cartoes cartao : lista.getCartoes())
                                System.out.println(cartao.getTitulo());
                        }
                    }
                }

            }
        }
    }
}
