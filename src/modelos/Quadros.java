package modelos;

import java.util.ArrayList;

public class Quadros {
    //Atributos
    private String titulo;
    private boolean favorito = false;
    private ArrayList<Listas> listas = new ArrayList<>();

    //Construtor
    public Quadros(String titulo) {
        this.titulo = titulo;
    }

    //Gettes e Settes

    public ArrayList<Listas> getListas() {
        return listas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isFavorito() {
        return favorito;
    }

    //Métodos
    public void favoritar(){
        this.favorito = !this.favorito;
    }

    public boolean criarLista(String titulo){
        for (Listas lista : listas){
            if (lista.getTitulo().equals(titulo)){
                return false;
            }
        }
        Listas nova_lista = new Listas(titulo);
        listas.add(nova_lista);
        return true;
    }

    public boolean deletarLista(Listas lista){
        if (lista.isArquivado()){
            listas.remove(lista);
            return true;
        }
        return false;
    }

    public boolean moverLista(Listas lista, int novaposicao){
        if (novaposicao <= listas.size()){
            listas.remove(lista);
            listas.add(novaposicao - 1, lista);
            return true;
        }
        return false;

    }

}
