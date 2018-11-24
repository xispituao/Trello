package modelos;

import java.util.ArrayList;

public class Usuario {
    //Atributos
    private String email;
    private String senha;
    private ArrayList<Quadro> quadros = new ArrayList<>();

    //Construtor
    public Usuario(String email, String senha) {
        setEmail(email);
        setSenha(senha);
    }

    //gettes e settes
    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
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

