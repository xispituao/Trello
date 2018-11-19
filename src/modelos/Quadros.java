package modelos;

import java.util.ArrayList;

public class Quadros {
    //Atributos
    private String titulo;
    private int ordem;
    private ArrayList<Listas> listas = new ArrayList<>();

    public Quadros(String titulo, int ordem) {
        this.titulo = titulo;
        this.ordem = ordem;
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

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    //Métodos
    public void criarLista(String nome){
        Listas nova_lista = new Listas(nome);
        listas.add(nova_lista);
    }

    public boolean deletarLista(String nome){
        for (int i = 0; i < listas.size(); i++){
            if (listas.get(i).getNome().equals(nome)){
                listas.remove(i);
                return true;
            }
        }
        return false;
    }

}
