package intermediario;

import modelos.*;

import java.util.ArrayList;

public class Services {
    private ArrayList<Usuarios> usuarios = new ArrayList<>();
    private Usuarios usuariologado = null;
    public Quadros quadroEmUso;
    public Listas listaEmUso = null;
    public Cartoes cartaoEmUso = null;


    public Quadros getQuadroEmUso() {
        return quadroEmUso;
    }

    public Listas getListaEmUso() {
        return listaEmUso;
    }

    public Cartoes getCartaoEmUso() {
        return cartaoEmUso;
    }

    public Usuarios getUsuariologado() {
        return usuariologado;
    }

    public boolean selecionarQuadro(String titulo){
        for (Quadros quadro :usuariologado.getQuadros()){
            if (quadro.getTitulo().equals(titulo)){
                this.quadroEmUso = quadro;
                return true;
            }
        }
        return false;
    }

    public boolean adicionarUsuario(String nome, String email, String senha){
        for (Usuarios usuario : usuarios){
            if (usuario.getEmail().equals(nome)){
                return false;
            }
        }
        Usuarios new_usuario = new Usuarios(nome, email, senha);
        usuarios.add(new_usuario);
        return true;
    }

    public boolean logar(String email, String senha){
        for (Usuarios usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuariologado = usuario;
                return true;
            }
        }
        return false;
    }

    public void deslogar(){
        this.usuariologado = null;
    }
    public boolean adicionarQuadro(String titulo){
        return usuariologado.adicionarQuadro(titulo);
    }

    public boolean adicionarLista(String nome_quadro, String titulo){

        for (Quadros quadro:usuariologado.getQuadros()) {
            if (quadro.getTitulo().equals(nome_quadro)){
               return quadro.criarLista(titulo);

            }
        }
        return false;
    }

    public boolean adicionarCartao(String titulo_quadro, String titulo_cartao, String titulo_lista){
        for (Quadros quadro:usuariologado.getQuadros()) {
            if (quadro.getTitulo().equals(titulo_quadro)){
                for (Listas lista : quadro.getListas()){
                    if (lista.getNome().equals(titulo_lista)){
                        return lista.adicionarCartao(titulo_cartao);
                    }
                }

            }
        }
        return false;
    }

    public ArrayList<Quadros> pegarQuadros(){
        return usuariologado.getQuadros();
    }

    public boolean moverCartao(int novaposicao){
        return listaEmUso.moverCartao(cartaoEmUso, novaposicao);
    }

    public boolean moverLista(int novaposicao){
        return quadroEmUso.moverLista(listaEmUso, novaposicao);
    }

    public boolean excluirCartao(){
        Cartoes cartao = cartaoEmUso;
        cartaoEmUso = null;
        return listaEmUso.excluirCartao(cartao);
    }

    public boolean arquivarCartao(){
        cartaoEmUso.setArquivado(true);
        Log newlog = new Log("arquivado");
        return true;
    }

    public boolean arquivarLista(){
        listaEmUso.setArquivado(true);
        return true;
    }

    /*public void mostrarAmbienteTrello(){
        ArrayList<Quadros> quadros = this.pegarQuadros();
        int quantidadesDeQuadros = quadros.size();
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(quantidadesDeQuadros);
        for (Quadros quadro: quadros){
            dados.add()
            dados.add(quadro.getListas().size());
            for (Listas lista : quadro.getListas()){
                dados.add(lista.getCartoes().size());

                for (Cartoes cartao : lista.getCartoes())
                    System.out.println(cartao.getTitulo());
            }
        }
    }*/
}
