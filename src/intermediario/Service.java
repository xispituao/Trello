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
    public boolean adicionarUsuario(String email, String senha){
        for (Usuario usuario : usuarios){
            if (usuario.getEmail().equals(email)){
                return false;
            }
        }
        Usuario new_usuario = new Usuario(email, senha);
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

    public void deletarLista(){
        quadroEmUso.deletarLista(listaEmUso);
        listaEmUso = null;
    }

    public void sairDaLista(){
        listaEmUso = null;
    }

    public boolean listaTaArquivada(){
        return listaEmUso.isArquivado();
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

    public boolean criarCartao(String titulo_cartao){
        return listaEmUso.adicionarCartao(titulo_cartao);
    }

    public boolean moverCartao(int novaposicao){
        return listaEmUso.moverCartao(cartaoEmUso, novaposicao);
    }

    public void excluirCartao(){
        Cartao cartao = cartaoEmUso;
        cartaoEmUso = null;
        listaEmUso.excluirCartao(cartao);
    }

    public void arquivarCartao(){
        if (cartaoEmUso.isArquivado()){
            cartaoEmUso.setArquivado();
            cartaoEmUso.addLog("desarquivado");
        }else {
            cartaoEmUso.setArquivado();
            cartaoEmUso.addLog("arquivado");
        }


    }

    public ArrayList<Cartao> pegarCartoes(){
        return listaEmUso.getCartoes();
    }

    public boolean cartaoTaArquivado(){
        return cartaoEmUso.isArquivado();
    }

    //Metodos etiquetas
    public void adicionarEtiqueta(String cor, String nome){
        cartaoEmUso.adicionarOuModificarEtiqueta(cor, nome);
    }

    public void excluirEtiqueta(String cor){
        cartaoEmUso.excluirEtiqueta(cor);
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

    //Metodos comentario
    public ArrayList<Comentario> comentarios(){
        return cartaoEmUso.getComentarios();
    }

    public void criarComentarios(String comentario){
        cartaoEmUso.criarComentario(comentario);
    }

    //Metodo log
    public ArrayList<Log> logs(){
        return cartaoEmUso.getLogs();
    }
}
