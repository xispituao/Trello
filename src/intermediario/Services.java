package intermediario;

import modelos.*;

import java.util.ArrayList;

public class Services {
    //Atributos
    private ArrayList<Usuarios> usuarios = new ArrayList<>();
    private Usuarios usuariologado = null;
    private Quadros quadroEmUso = null;
    private Listas listaEmUso = null;
    private Cartoes cartaoEmUso = null;


    //Getters e setters
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


    //Metodos do usuario
    public boolean adicionarUsuario(String nome, String email, String senha){
        for (Usuarios usuario : usuarios){
            if (usuario.getEmail().equals(email)){
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

    //Metodos de quadro
    public boolean adicionarQuadro(String titulo){
        return usuariologado.adicionarQuadro(titulo);
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

    public void favoritarQuadro(){
        quadroEmUso.favoritar();
    }

    public ArrayList<Quadros> listarQuadrosFavoritos(){
        return usuariologado.pegarQuadrosFavoritos();
    }

    public ArrayList<Quadros> listarQuadrosNaoFavoritos(){
        return usuariologado.pegarQuadrosNaoFavoritos();
    }

    public void sairDoQuadro(){
        quadroEmUso = null;
    }

    //Metodos para lista
    public boolean adicionarLista(String titulo){
        return quadroEmUso.criarLista(titulo);
    }

    public boolean selecionarLista(String titulo){
        for (Listas lista :quadroEmUso.getListas()){
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
    public boolean adicionarCartao(String titulo_quadro, String titulo_cartao, String titulo_lista){
        for (Quadros quadro:usuariologado.getQuadros()) {
            if (quadro.getTitulo().equals(titulo_quadro)){
                for (Listas lista : quadro.getListas()){
                    if (lista.getTitulo().equals(titulo_lista)){
                        return lista.adicionarCartao(titulo_cartao);
                    }
                }

            }
        }
        return false;
    }

    public boolean moverCartao(int novaposicao){
        return listaEmUso.moverCartao(cartaoEmUso, novaposicao);
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





    //Metodo para teste
    public ArrayList<Quadros> pegarQuadros(){
        return usuariologado.getQuadros();
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
