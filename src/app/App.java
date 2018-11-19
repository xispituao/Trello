package app;

import modelos.Quadros;
import modelos.Usuarios;

public class App {
    public static void main(String[] args){
        Quadros quadro = new Quadros();
        quadro.criarLista("Teste");
        for (int i = 0 ;i < quadro.getListas().size(); i++){
            System.out.println(quadro.getListas().get(i).getNome());
        }
    }
}
