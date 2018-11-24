package modelos;

public class Etiqueta {
    //Atributos
    private boolean sendo_usada = false;
    private String cor;
    private String nome;

    //Construtor
    Etiqueta(String cor){
        setCor(cor);
    }

    //Getters e Setters

    public boolean isSendo_usada() {
        return sendo_usada;
    }

    void setSendo_usada() {
        this.sendo_usada = !this.sendo_usada;
    }

    String getCor() {
        return cor;
    }

    private void setCor(String cor) {
        this.cor = cor;
    }

    void setNome(String nome) {
        this.nome = nome;
    }
        //Overload
        void setNome(){
        this.nome = null;
    }

    @Override
    public String toString(){
        return cor + ": " + nome;
    }
}
