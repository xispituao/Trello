package modelos;

public class Log {
    //Atributos
    private String estado;
    private int posicao;

    //Construtores
    public Log(String estado, int posicao) {
        setEstado(estado);
        setPosicao(posicao);
    }
        //Overload
    public Log(String estado){
        setEstado(estado);
    }

    //Getters e Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString(){
        return estado + posicao;
    }
}
