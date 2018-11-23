package modelos;

import java.util.ArrayList;

public class Lista {
    //Atributos
    private String titulo;
    private boolean arquivado;
    private ArrayList<Cartao> cartoes = new ArrayList<>();

    //Construtor
    public Lista(String nome) {
        setTitulo(nome);
        setArquivado(false);
    }

    //Getters e setters
    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Metodos
    public void arquivar(){
        setArquivado(!arquivado);
    }

    public boolean adicionarCartao(String titulo){
        for (Cartao cartao: cartoes) {
            if(cartao.getTitulo().equals(titulo)){
                return false;
            }
        }
        Cartao newcartao = new Cartao(titulo);
        cartoes.add(0,newcartao);
        newcartao.addLog("Criado",0);

        return true;
    }

    public boolean moverCartao(Cartao cartao, int posicaoDestino){
        cartoes.remove(cartao);
        cartoes.add(posicaoDestino - 1,cartao);
        Log log = new Log("movido",posicaoDestino);
        return true;
    }

    public boolean excluirCartao(Cartao cartao){
        cartoes.remove(cartao);
        return true;
    }

    @Override
    public String toString(){
        return getTitulo();
    }
}
