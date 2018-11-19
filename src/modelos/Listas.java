package modelos;

import java.util.ArrayList;

public class Listas {
    private String nome;
    private ArrayList<Cartoes> cartoes = new ArrayList<>();

    public Listas(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCartao(String titulo, String descricao){
        Cartoes newcartao = new Cartoes(titulo, descricao);
        cartoes.add(newcartao);
    }
}
