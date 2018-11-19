package intermediario;

import modelos.Usuarios;

import java.util.ArrayList;

public class Services {
    private ArrayList<Usuarios> usuarios = new ArrayList<>();

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
                return true;
            }
        }
        return false;
    }
}
