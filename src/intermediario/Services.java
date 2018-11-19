package intermediario;

import modelos.Quadros;
import modelos.Usuarios;

import java.util.ArrayList;

public class Services {
    private ArrayList<Usuarios> usuarios = new ArrayList<>();
    private Usuarios usuariologado;

    public boolean adicionarUsuario(String nome, String email, String senha){
        for (Usuarios usuario : usuarios){
            if (usuario.getEmail().equals(nome)){
                return false;
            }
        }
        Usuarios new_usuario = new Usuarios(nome, email, senha);
        usuarios.add(new_usuario);
        return true;
    }

    public boolean logar(String email, String senha){
        for (Usuarios usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuariologado = usuario;
                return true;
            }
        }
        return false;
    }

    public void adicionarQuadro(String titulo){
        usuariologado.adicionarQuadro(titulo);
    }

    public boolean adicionarLista(String nome_quadro, String titulo){

        for (Quadros quadro:usuariologado.getQuadros()) {
            if (quadro.getTitulo().equals(nome_quadro)){
               return quadro.criarLista(titulo);

            }
        }
        return false;
    }

    public void adicionarCartao(String titulo_quadro, String titulo_cartao, String titulo_lista){
        for (Quadros quadro:usuariologado.getQuadros()) {
            if (quadro.getTitulo().equals(titulo_quadro)){
                return quadro.criarLista(titulo);

            }
        }
    }
}
