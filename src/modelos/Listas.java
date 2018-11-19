package modelos;

import java.util.ArrayList;

public class Listas {
    private String nome;
    private ArrayList<Cartoes> cartoes = new ArrayList<>();

    public Listas(String nome) {
        setNome(nome);
    }

    public ArrayList<Cartoes> getCartoes() {
        return cartoes;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean adicionarCartao(String titulo){
        Cartoes newcartao = new Cartoes(titulo);
        cartoes.add(newcartao);
        return true;
    }
}
