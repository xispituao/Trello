package intermediario;

import modelos.*;

import java.util.ArrayList;

public class Service {
    //Atributos
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Usuario usuariologado = null;
    private Quadro quadroEmUso = null;
    private Lista listaEmUso = null;
    private Cartao cartaoEmUso = null;


    //Getters e setters
    public Quadro getQuadroEmUso() {
        return quadroEmUso;
    }

    public Lista getListaEmUso() {
        return listaEmUso;
    }

    public Cartao getCartaoEmUso() {
        return cartaoEmUso;
    }

    public Usuario getUsuariologado() {
        return usuariologado;
    }


    //Metodos do usuario
    public boolean adicionarUsuario(String nome, String email, String senha){
        for (Usuario usuario : usuarios){
            if (usuario.getEmail().equals(email)){
                return false;
            }
        }
        Usuario new_usuario = new Usuario(nome, email, senha);
        usuarios.add(new_usuario);
        return true;
    }

    public boolean logar(String email, String senha){
        for (Usuario usuario : usuarios) {
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

    //Metodos de quadro
    public boolean adicionarQuadro(String titulo){
        return usuariologado.adicionarQuadro(titulo);
    }

    public boolean selecionarQuadro(String titulo){
        for (Quadro quadro :usuariologado.getQuadros()){
            if (quadro.getTitulo().equals(titulo)){
                this.quadroEmUso = quadro;
                return true;
            }
        }
        return false;
    }

    public void favoritarQuadro(){
        quadroEmUso.favoritar();
    }

    public ArrayList<Object> listarQuadrosFavoritos(){
        return usuariologado.pegarQuadrosFavoritos();
    }

    public ArrayList<Object> listarQuadrosNaoFavoritos(){
        return usuariologado.pegarQuadrosNaoFavoritos();
    }

    public void sairDoQuadro(){
        quadroEmUso = null;
    }

    //Metodos para lista
    public ArrayList<Lista> listas(){
        return quadroEmUso.getListas();
    }

    public boolean adicionarLista(String titulo){
        return quadroEmUso.criarLista(titulo);
    }

    public boolean selecionarLista(String titulo){
        for (Lista lista :quadroEmUso.getListas()){
            if (lista.getTitulo().equals(titulo)){
                this.listaEmUso = lista;
                return true;
            }
        }
        return false;
    }

    public boolean moverLista(int novaposicao){
        return quadroEmUso.moverLista(listaEmUso, novaposicao);
    }

    public void arquivarLista(){
        listaEmUso.arquivar();
    }

    public boolean deletarLista(){
        if (quadroEmUso.deletarLista(listaEmUso)){
            listaEmUso = null;
            return true;
        }else {
            return false;
        }
    }

    public void sairDaLista(){
        listaEmUso = null;
    }

    //Metodos para cartao
    public boolean selecionarCartao(String titulo){
        for (Cartao cartao :listaEmUso.getCartoes()){
            if (cartao.getTitulo().equals(titulo)){
                this.cartaoEmUso = cartao;
                return true;
            }
        }
        return false;
    }

    public void sairDoCartao(){
        cartaoEmUso = null;
    }

    public String criarCartao(String titulo_cartao){
        if(listaEmUso.isArquivado()){
            return "Arquivado";
        }else {
            if (listaEmUso.adicionarCartao(titulo_cartao)){
                return "Criado";
            }else {
                return "JaExiste";
            }
        }

    }

    public boolean moverCartao(int novaposicao){
        return listaEmUso.moverCartao(cartaoEmUso, novaposicao);
    }

    public boolean excluirCartao(){
        Cartao cartao = cartaoEmUso;
        cartaoEmUso = null;
        return listaEmUso.excluirCartao(cartao);
    }

    public boolean arquivarCartao(){
        cartaoEmUso.setArquivado(true);
        Log newlog = new Log("arquivado");
        return true;
    }

    public ArrayList<Cartao> pegarCartoes(){
        return listaEmUso.getCartoes();
    }
    public ArrayList<Etiqueta> pegarEtiquetas(){
        return cartaoEmUso.getEtiquetas();
    }

    public void adicionarEtiqueta(String cor, String nome){
        cartaoEmUso.adicionarOuModificarEtiqueta(cor, nome);
    }





    public ArrayList<Comentario> comentarios(){
        return cartaoEmUso.getComentarios();
    }

    public void criarComentarios(String comentario){
        cartaoEmUso.criarComentario(comentario);
    }

    public ArrayList<Etiqueta> etiquetas(){
        ArrayList<Etiqueta> etiquetas = new ArrayList<>();
        for (Etiqueta etiqueta: cartaoEmUso.getEtiquetas()){
            if (etiqueta.isSendo_usada()){
                etiquetas.add(etiqueta);
            }
        }
        return etiquetas;
    }
}
