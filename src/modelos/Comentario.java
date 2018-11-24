package modelos;

public class Comentario {
    private String conteudo;

    Comentario(String comentario){
        setConteudo(comentario);
    }

    private void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString(){
        return conteudo;
    }


}
