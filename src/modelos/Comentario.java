package modelos;

public class Comentario {
    private String conteudo;

    public Comentario(String comentario){
        setConteudo(comentario);
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString(){
        return conteudo;
    }


}
