package modelos;

import java.util.ArrayList;

public class Usuario {
    //Atributos
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Quadro> quadros = new ArrayList<>();

    //Construtor
    public Usuario(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    //gettes e settes
    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }

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
    public boolean adicionarQuadro(String titulo) {
        for(Quadro quadro : quadros){
            if (quadro.getTitulo().equals(titulo)){
                return false;
            }
        }
        Quadro new_quadro = new Quadro(titulo);
        quadros.add(new_quadro);
        return true;
    }

    public ArrayList<Object> pegarQuadrosFavoritos(){
        ArrayList<Object> quadros_favoritos = new ArrayList<>();
        for (Quadro quadro : quadros){
            if (quadro.isFavorito()){
                quadros_favoritos.add(quadro.getTitulo());
            }
        }
        return quadros_favoritos;
    }

    public ArrayList<Object> pegarQuadrosNaoFavoritos(){
        ArrayList<Object> quadros_nao_favoritos = new ArrayList<>();
        for (Quadro quadro : quadros){
            if (!quadro.isFavorito()){
                quadros_nao_favoritos.add(quadro.getTitulo());
            }
        }
        return quadros_nao_favoritos;
    }

}

