package modelos;

import java.util.ArrayList;

public class Quadro {
    //Atributos
    private String titulo;
    private boolean favorito = false;
    private ArrayList<Lista> listas = new ArrayList<>();

    //Construtor
    Quadro(String titulo) {
        this.titulo = titulo;
    }

    //Gettes e Settes

    public ArrayList<Lista> getListas() {
        return listas;
    }

    public String getTitulo() {
        return titulo;
    }

    boolean isFavorito() {
        return favorito;
    }

    //Métodos
    public void favoritar(){
        this.favorito = !this.favorito;
    }

    public boolean criarLista(String titulo){
        for (Lista lista : listas){
            if (lista.getTitulo().equals(titulo)){
                return false;
            }
        }
        Lista nova_lista = new Lista(titulo);
        listas.add(nova_lista);
        return true;
    }

    public void deletarLista(Lista lista) {
        listas.remove(lista);
    }

    public boolean moverLista(Lista lista, int novaposicao){
        if (novaposicao <= listas.size() && novaposicao != 0){
            listas.remove(lista);
            listas.add(novaposicao - 1, lista);
            return true;
        }
        return false;

    }

}
