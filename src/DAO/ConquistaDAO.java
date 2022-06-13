package DAO;

import DTO.ChecarConquistaDTO;
import DTO.ExibirConquistaDTO;
import dataBase.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//tipoConquista = true (tempo), tipoConquista = false (streak)
public class ConquistaDAO {

    Connection conn;

    public ArrayList<ExibirConquistaDTO> ListarConquistaUsuario(int idUsuario) {
        conn = ConnectionFactory.getConnection();
        ArrayList<ExibirConquistaDTO> lista = new ArrayList<>();

        String query = "SELECT UC.idConquista, C.idConquista, C.tituloConquista, C.tipoConquista, C.descricaoConquista FROM usuarioConquista as UC INNER JOIN Conquista AS C ON C.idConquista = UC.idConquista WHERE idUsuario = ?;";

        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idUsuario);

            try ( ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    do {
                        ExibirConquistaDTO conquistaDTO = new ExibirConquistaDTO();

                        conquistaDTO.setIdConquista(rs.getInt("idConquista"));
                        conquistaDTO.setTitulo(rs.getString("tituloConquista"));
                        conquistaDTO.setDescricao(rs.getString("descricaoConquista"));
                        // conquistaDTO.setLiberada(true);

                        lista.add(conquistaDTO);
                    } while (rs.next());
                }
            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsquistaDAO\n" + erro);
        }
        return lista;
    }

    public ArrayList<ChecarConquistaDTO> ListarConquistaUsuarioNaoLiberadas(int idUsuario, boolean tipoConquista) {
        conn = ConnectionFactory.getConnection();
        ArrayList<ChecarConquistaDTO> lista = new ArrayList<>();

        String query = "SELECT idConquista, dadoConquista, tipoConquista FROM conquista WHERE idConquista NOT IN(SELECT UC.idConquista FROM usuarioConquista as UC INNER JOIN Conquista AS C ON C.idConquista = UC.idConquista WHERE idUsuario = ?) AND tipoConquista = ?;";

        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idUsuario);
            pstm.setBoolean(2, tipoConquista);

            try ( ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    do {
                        ChecarConquistaDTO conquistaDTO = new ChecarConquistaDTO();

                        conquistaDTO.setIdConquista(rs.getInt("idConquista"));
                        conquistaDTO.setDadoConquista(rs.getInt("dadoConquista"));
                        conquistaDTO.setTipoConquista(rs.getBoolean("tipoConquista"));
                        // conquistaDTO.setLiberada(true);

                        lista.add(conquistaDTO);
                    } while (rs.next());
                }
            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsquistaDAO\n" + erro);
        }
        return lista;
    }

    public void LiberarConquista(int idUsuario, int idConquista){
        conn = ConnectionFactory.getConnection();
        String query = "INSERT INTO usuarioConquista values(? , ?)";

        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idUsuario);
            pstm.setInt(2, idConquista);
            pstm.execute();
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsquistaDAO\n" + erro);
        }
    }

    public ExibirConquistaDTO getConquistaById(int idConquista){
        conn = ConnectionFactory.getConnection();
        String query = "SELECT tituloConquista, descricaoConquista FROM conquista WHERE idConquista = ?";
        ExibirConquistaDTO exibirConquista = new ExibirConquistaDTO();
        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idConquista);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                exibirConquista.setIdConquista(idConquista);
                exibirConquista.setDescricao(rs.getString("descricaoConquista"));
                exibirConquista.setTitulo(rs.getString("tituloConquista"));

            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsquistaDAO\n" + erro);
        }
        return exibirConquista;
    }
}
