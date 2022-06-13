package DTO;

public class ExibirConquistaDTO {
    
    private int idConquista;
    private String titulo, descricao;
    // private boolean liberada;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // public boolean isLiberada() {
    //     return liberada;
    // }

    // public void setLiberada(boolean liberada) {
    //     this.liberada = liberada;
    // }
    
    
    public int getIdConquista() {
        return idConquista;
    }

    public void setIdConquista(int idConquista) {
        this.idConquista = idConquista;
    }
   
}    
