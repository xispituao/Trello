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
    public ArrayList<Quadros> getQuadros() {
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
        for(Quadros quadro : quadros){
            if (quadro.getTitulo().equals(titulo)){
                return false;
            }
        }
        Quadros new_quadro = new Quadros(titulo);
        quadros.add(new_quadro);
        return true;
    }

    public ArrayList<Quadros> pegarQuadrosFavoritos(){
        ArrayList<Quadros> quadros_favoritos = new ArrayList<>();
        for (Quadros quadro : quadros){
            if (quadro.isFavorito()){
                quadros_favoritos.add(quadro);
            }
        }
        return quadros_favoritos;
    }

    public ArrayList<Quadros> pegarQuadrosNaoFavoritos(){
        ArrayList<Quadros> quadros_nao_favoritos = new ArrayList<>();
        for (Quadros quadro : quadros){
            if (!quadro.isFavorito()){
                quadros_nao_favoritos.add(quadro);
            }
        }
        return quadros_nao_favoritos;
    }

}

