package DTO;

public class ConquistaDTO {
    private int idConquista;
    private double dadoConquista;
    private boolean tipoConquista;
    private String titulo, descricao;

    public int getIdConquista() {
        return idConquista;
    }

    public void setIdConquista(int idConquista) {
        this.idConquista = idConquista;
    }

    public double getDadoConquista() {
        return dadoConquista;
    }

    public void setDadoConquista(Double dadoConquista) {
        this.dadoConquista = dadoConquista;
    }

    public boolean getTipoConquista() {
        return tipoConquista;
    }

    public void setTipoConquista(boolean tipoConquista) {
        this.tipoConquista = tipoConquista;
    }

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
}
