package DAO;

import DTO.UsuarioDTO;
import dataBase.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PesquisaDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();
    
    public ArrayList<UsuarioDTO> PesquisarUsuario(){
  
        String sql = "SELECT * FROM usuario ORDER BY nivel";
        conn = ConnectionFactory.getConnection();
       
        try {
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
            UsuarioDTO usuarioOBJ = new UsuarioDTO();
            
            usuarioOBJ.setNickname(rs.getString("nickname"));
            usuarioOBJ.setNivel(rs.getInt("nivel"));
            usuarioOBJ.setNumeroFase(rs.getInt("numeroFase"));
            
            lista.add(usuarioOBJ);
            
            }
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "PesquisarUsuario" + erro);
        }
        return lista;
    }
}
