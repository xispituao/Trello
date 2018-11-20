package modelos;

public class Log {
    private String estado;
    private int posicao;

    public Log(String estado, int posicao) {
        setEstado(estado);
        setPosicao(posicao);
    }

    public Log(String estado){
        setEstado(estado);
    }
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
}
