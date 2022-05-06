package DAO;

import DTO.CadastroDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class CadastroDAO {

    Connection conn;
    PreparedStatement pstm;

    public void cadastrarUsuario(CadastroDTO objcadastrardto) {
        String sql = "insert into usuario( senha, email, nickname) values (?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastrardto.getSenha ());
            pstm.setString(2, objcadastrardto.getEmail());
            pstm.setString(3, objcadastrardto.getNickname());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "CadastroDAO" + erro);
        }

    }
}
