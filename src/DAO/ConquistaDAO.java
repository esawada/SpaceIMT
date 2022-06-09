package DAO;

import DTO.ConquistaDTO;
import dataBase.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConquistaDAO {

    Connection conn;

    public ArrayList<ConquistaDTO> ListarConquistaUsuario(int idUsuario) {
        conn = ConnectionFactory.getConnection();
        ArrayList<ConquistaDTO> lista = new ArrayList<>();

        String query = "SELECT UC.idConquista, C.idConquista, C.tituloConquista, C.tipoConquista, C.descricaoConquista FROM usuarioConquista as UC INNER JOIN Conquista AS C ON C.idConquista = UC.idConquista WHERE idUsuario = ?;";

        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idUsuario);

            try ( ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    do {
                        ConquistaDTO conquistaDTO = new ConquistaDTO();

                        conquistaDTO.setIdConquista(rs.getInt("idConquista"));
                        conquistaDTO.setTitulo(rs.getString("tituloConquista"));
                        conquistaDTO.setDescricao(rs.getString("descricaoConquista"));
                        conquistaDTO.setLiberada(true);

                        lista.add(conquistaDTO);
                    } while (rs.next());
                }
            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsquistaDAO\n" + erro);
        }
        return lista;
    }
}
