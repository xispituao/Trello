package modelos;

import java.util.ArrayList;

public class Usuarios {
    //Atributos
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Quadros> quadros = new ArrayList<>();

    //Construtor


    public Usuarios(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    //gettes e settes
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Métodos
    /*public void adicionarQuadro(){
        Quadros new_quadro = new Quadros();
    }*/


}
