package modelos;

public class Etiqueta {
    //Atributos
    private boolean sendo_usada = false;
    private String cor;
    private String nome;

    //Construtor
    public Etiqueta(String cor){
        setCor(cor);
    }

    //Getters e Setters

    public boolean isSendo_usada() {
        return sendo_usada;
    }

    public void setSendo_usada() {
        this.sendo_usada = !this.sendo_usada;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        //Overload
    public void setNome(){
        this.nome = null;
    }

    @Override
    public String toString(){
        return cor + ": " + nome;
    }
}
