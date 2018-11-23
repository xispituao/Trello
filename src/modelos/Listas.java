package modelos;

import java.util.ArrayList;

public class Listas {
    private String titulo;
    private boolean arquivado;
    private ArrayList<Cartoes> cartoes = new ArrayList<>();

    public Listas(String nome) {
        setTitulo(nome);
        setArquivado(false);
    }

    public ArrayList<Cartoes> getCartoes() {
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

    public void arquivar(){
        setArquivado(!arquivado);
    }

    public boolean adicionarCartao(String titulo){
        Cartoes newcartao = new Cartoes(titulo);
        cartoes.add(0,newcartao);
        newcartao.addLog("Criado",0);

        return true;
    }

    public boolean moverCartao(Cartoes cartao, int posicaoDestino){
        cartoes.remove(cartao);
        cartoes.add(posicaoDestino - 1,cartao);
        Log log = new Log("movido",posicaoDestino);
        return true;
    }

    public boolean excluirCartao(Cartoes cartao){
        cartoes.remove(cartao);
        return true;
    }
}
