package modelos;

import java.util.ArrayList;

public class Cartoes {
    private String titulo;
    private String descricao;
    private ArrayList<Comentarios> comentarios = new ArrayList<>();
    private ArrayList<Etiqueta> etiquetas = new ArrayList<>();

    public Cartoes(String titulo, String descricao){
        setTitulo(titulo);
        setDescricao(descricao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void criarComentario(String comentario){
        Comentarios newcomentario = new Comentarios(comentario);
        comentarios.add(newcomentario);
    }

    public void adicionarEtiqueta(String cor){
        Etiqueta newetiqueta = new Etiqueta(cor);
        etiquetas.add(newetiqueta);
    }
}
