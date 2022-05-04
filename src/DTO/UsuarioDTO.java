
package DTO;


public class UsuarioDTO {
   
    private int Id_Usuario;
    private String email, senha;

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getEmail_usuario() {
        return email;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email = email_usuario;
    }

    public String getSenha_usuario() {
        return senha;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha = senha_usuario;
    }
    
}
