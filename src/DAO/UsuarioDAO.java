package DAO;

import DTO.UsuarioDTO;
import dataBase.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        
        conn = ConnectionFactory.getConnection();
                
        try {
            String sql = "select * from usuario where email = ? and senha = ?";
            
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getEmail_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
    public static int GetFaseByID(int idUsuario) {
    
    String sql = "SELECT numeroFase FROM usuario WHERE idUsuario = ? ";
    int fase = 0;
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet resultSet = stmt.executeQuery();
                
                if (resultSet.next()) {
                    fase = resultSet.getInt("numeroFase");
                }

                stmt.close();
                con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        return fase;
    }

    public static void IncrementarFase(int idUsuario) {
    
    String sql = "UPDATE usuario SET numeroFase = numeroFase + 1 WHERE idUsuario = ?";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.execute();
            stmt.close();
            con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
}
