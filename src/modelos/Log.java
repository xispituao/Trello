package modelos;

public class Log {
    //Atributos
    private String estado;
    private int posicao;

    //Construtores
    Log(String estado, int posicao) {
        setEstado(estado);
        setPosicao(posicao);
    }
        //Overload
        Log(String estado){
        setEstado(estado);
    }

    //Getters e Setters
    private void setEstado(String estado) {
        this.estado = estado;
    }

    private void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString(){
        switch (estado) {
            case "Criado":
                return estado;
            case "Movido":
                return estado + " para a posicao " + posicao;
            default:
                return estado;
        }

    }
}
