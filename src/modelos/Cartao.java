package modelos;

import java.util.ArrayList;

public class Cartao {
    //Atributos
    private String titulo;
    private boolean arquivado;
    private ArrayList<Comentario> comentarios = new ArrayList<>();
    private ArrayList<Etiqueta> etiquetas = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();

    //Construtor
    Cartao(String titulo){
        setTitulo(titulo);
        arquivado = false;
        Etiqueta vermelho = new Etiqueta("Vermelho");
        Etiqueta amarelo = new Etiqueta("Amarelo");
        Etiqueta laranja = new Etiqueta("Laranja");
        Etiqueta roxo = new Etiqueta("Roxo");
        Etiqueta azul = new Etiqueta("Azul");
        etiquetas.add(vermelho);
        etiquetas.add(amarelo);
        etiquetas.add(laranja);
        etiquetas.add(roxo);
        etiquetas.add(azul);
    }

    //Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado() {
        this.arquivado = !this.arquivado;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    //Metodos
    public void criarComentario(String comentario){
        Comentario newcomentario = new Comentario(comentario);
        comentarios.add(newcomentario);
        this.addLog("Criado comentario");
    }

    public void adicionarOuModificarEtiqueta(String cor, String nome){
        for (Etiqueta etiqueta:etiquetas) {
            if(etiqueta.getCor().equals(cor)){
                if(etiqueta.isSendo_usada()){
                    etiqueta.setNome(nome);
                    this.addLog("Etiqueta modificada");
                }else{
                    etiqueta.setSendo_usada();
                    etiqueta.setNome(nome);
                    this.addLog("Etiqueta criada");
                }

            }
        }
    }

    public void excluirEtiqueta(String cor){
        for(Etiqueta etiqueta:etiquetas){
            if(etiqueta.getCor().equals(cor)){
                etiqueta.setSendo_usada();
                etiqueta.setNome();
                this.addLog("etiqueta excluida");
            }
        }
    }

    void addLog(String estado, int posicao){
        Log newlog = new Log(estado, posicao);
        logs.add(newlog);
    }

    public void addLog(String estado){
        Log newlog = new Log(estado);
        logs.add(newlog);
    }

    @Override
    public String toString(){
        return getTitulo();
    }
}
