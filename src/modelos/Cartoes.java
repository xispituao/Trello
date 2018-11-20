package modelos;

import java.util.ArrayList;

public class Cartoes {
    private String titulo;
    private String descricao;
    private boolean arquivado;
    private ArrayList<Comentarios> comentarios = new ArrayList<>();
    private ArrayList<Etiqueta> etiquetas = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();

    public Cartoes(String titulo){
        setTitulo(titulo);
        setArquivado(false);
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

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    public void criarComentario(String comentario){
        Comentarios newcomentario = new Comentarios(comentario);
        comentarios.add(newcomentario);
    }

    public void adicionarEtiqueta(String cor){
        Etiqueta newetiqueta = new Etiqueta(cor);
        etiquetas.add(newetiqueta);
    }

    public void addLog(String estado, int posicao){
        Log newlog = new Log(estado, posicao);
        logs.add(newlog);
    }
}
