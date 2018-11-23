package app;

import intermediario.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Service intermediario = new Service();
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
                if (!intermediario.etiquetas().isEmpty()){
                    System.out.println("\tEtiquetas");
                    for(int i = 0; i< intermediario.etiquetas().size();i++){
                        System.out.println(intermediario.etiquetas().get(i));
                    }
                }

                if (!intermediario.comentarios().isEmpty()){
                    System.out.println("\tComentario");
                    for(int i = 0; i< intermediario.comentarios().size();i++){
                        System.out.println(intermediario.comentarios().get(i));
                    }
                }


                System.out.println("1 - Criar Comentário\n" +
                        "2 - Adicionar ou  modificar o nome da Etiqueta\n" +
                        "3 - Retirar etiqueta\n" +
                        "4 - Mover cartao\n" +
                        "5 - Arquivar cartao\n" +
                        "6 - Excluir cartao" +
                        "0 - Sair do cartao");
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 0:
                        intermediario.sairDoCartao();
                        System.out.println("Saindo do cartao...");
                        break;
                    case 1:
                        System.out.println("Comentario:");

                        String comentario = scanner1.nextLine();
                        intermediario.criarComentarios(comentario);
                        System.out.println("Sucesso");
                        break;
                    case 2:
                        System.out.println("Selecione uma das cores:\n" +
                                "1 - Vermelho\n" +
                                "2 - Amarelo\n" +
                                "3 - Laranja\n" +
                                "4 - Roxo\n" +
                                "5 - Azul\n");

                        int opcao2 = scanner.nextInt();
                        System.out.println("Dê uma descricao da etiqueta:");
                        String descricao = scanner1.nextLine();
                        switch (opcao2){
                            case 1:
                                intermediario.adicionarEtiqueta("Vermelho",descricao);
                                break;
                            case 2:
                                intermediario.adicionarEtiqueta("Amarelo",descricao);
                                break;
                            case 3:
                                intermediario.adicionarEtiqueta("Laranja",descricao);
                                break;
                            case 4:
                                intermediario.adicionarEtiqueta("Roxo",descricao);
                                break;
                            case 5:
                                intermediario.adicionarEtiqueta("Azul",descricao);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Qual das etiquetas abaixo quer remover?(Digite o  da cor exatamente igual!)");
                        if (intermediario.etiquetas().isEmpty()){
                            System.out.println("Sem etiquetas!");
                        }else {
                            for (int i= 0;i < intermediario.etiquetas().size();i++){
                                System.out.println(intermediario.etiquetas().get(i));
                            }
                            String etiqueta = scanner.next();
                            intermediario.excluirEtiqueta(etiqueta);
                            break;
                        }
                    case 4:
                        System.out.println("Nova posicao?");
                        int posicao = scanner.nextInt();
                        intermediario.moverCartao(posicao);
                        System.out.println("Sucesso!");
                        break;
                    case 5:
                        intermediario.arquivarCartao();
                        System.out.println("Sucesso!");
                        break;
                    case 6:
                        System.out.println("Continuar?\n1 - sim\n2 - nao");
                        int continuar = scanner.nextInt();
                        if (continuar == 1){
                            if (intermediario.excluirCartao()){
                                System.out.println("Apagado");
                            }else {
                                System.out.println("Arquive primeiro!");
                            }

                        }else if(continuar == 2){
                            System.out.println("Cancelado1");
                        }else {
                            System.out.println("Digite uma opcao valida!");
                        }
                }


            }else if(intermediario.getListaEmUso()!=null){
                if (!intermediario.pegarCartoes().isEmpty()){
                    System.out.println("\tCartao da lista " + intermediario.getListaEmUso());
                    for (int i =0; i < intermediario.pegarCartoes().size();i++){
                        if (intermediario.pegarCartoes().get(i).isArquivado()){
                            System.out.println(intermediario.pegarCartoes().get(i) + " ->Arquivado");
                        }else {
                            System.out.println(intermediario.pegarCartoes().get(i));
                        }
                    }
                }
                System.out.println("1 - Mover lista\n" +
                        "2 - Arquivar ou desarquivar lista\n" +
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
                    case 4:
                        System.out.println("Titulo: ");
                        String titulo = scanner.next();
                        String situacao = intermediario.criarCartao(titulo);
                        if (situacao.equals("Criado")){
                            System.out.println("Cartao criado!");
                        }else if(situacao.equals("Arquivado")){
                            System.out.println("Lista precisa ser desarquivado antes de criar um cartao novo!");
                        }else {
                            System.out.println("Cartao ja existe!");
                        }
                        break;
                    case 5:
                        System.out.println("Titulo: ");
                        titulo = scanner.next();
                        if (intermediario.selecionarCartao(titulo)){
                            System.out.println("Cartao selecionada!");
                        }else {
                            System.out.println("Cartao não existe!");
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
                if (!intermediario.listas().isEmpty()){
                    System.out.println("\tLista do quadro  " + intermediario.getQuadroEmUso().getTitulo());
                    for(int i =0;i < intermediario.listas().size(); i++){
                        if (intermediario.listas().get(i).isArquivado()){
                            System.out.println(intermediario.listas().get(i) + "  ->ARQUIVADO");
                        }else {
                            System.out.println(intermediario.listas().get(i));
                        }
                    }
                }
                System.out.println("\n1 - Favoritar ou desfavoritar quadro\n" +
                        "2 - Criar lista\n" +
                        "3 - Usar lista\n" +
                        "0 - Sair do quadro");
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1:
                        intermediario.favoritarQuadro();
                        System.out.println("Sucesso!");
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
                ArrayList<Object> quadrosfavoritos = intermediario.listarQuadrosFavoritos();
                ArrayList<Object> quadrosnaofavoritos = intermediario.listarQuadrosNaoFavoritos();

                if (!quadrosfavoritos.isEmpty()){
                    System.out.println("\tQuadro favoritos");
                    for (Object quadrofavorito : quadrosfavoritos) {
                        System.out.println(quadrofavorito + "\n");
                    }
                }

                if (!quadrosnaofavoritos.isEmpty()){
                    System.out.println("\tQuadro");
                    for (Object quadro : quadrosnaofavoritos) {
                        System.out.println(quadro + "\n");
                    }
                }

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
                        System.out.println("Quadro ja existe !");
                    }
                }else if(opcao == 2){
                    System.out.println("Título: ");
                    String titulo = scanner.next();
                    if (intermediario.selecionarQuadro(titulo)){
                        System.out.println("Quadro selecionado.");
                    }else {
                        System.out.println("Quadro nao existe !");
                    }

                }else {
                    System.out.println("Escola uma opcao valida!");
                }

            }
        }
    }
}
