package modelos;

import java.util.ArrayList;

public class Listas {
    private String nome;
    private boolean arquivado;
    private ArrayList<Cartoes> cartoes = new ArrayList<>();

    public Listas(String nome) {
        setNome(nome);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean adicionarCartao(String titulo){
        Cartoes newcartao = new Cartoes(titulo);
        cartoes.add(0,newcartao);
        newcartao.addLog("Criado",0);

        return true;
    }

    public boolean moverCartao(Cartoes cartao, int posicaoDestino){
        cartoes.remove(cartao);
        cartoes.add(posicaoDestino,cartao);
        Log log = new Log("movido",posicaoDestino);
        return true;
    }
}
