package DAO;

import DTO.ConquistaDTO;
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

    public ArrayList<ConquistaDTO> ListarConquistaUsuarioNaoLiberadas(int idUsuario, boolean tipoConquista) {
        conn = ConnectionFactory.getConnection();
        ArrayList<ConquistaDTO> lista = new ArrayList<>();

        String query = "SELECT idConquista, dadoConquista, tipoConquista FROM conquista WHERE idConquista NOT IN(SELECT UC.idConquista FROM usuarioConquista as UC INNER JOIN Conquista AS C ON C.idConquista = UC.idConquista WHERE idUsuario = ?) AND tipoConquista = ?;";

        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idUsuario);
            pstm.setBoolean(2, tipoConquista);

            try ( ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    do {
                        ConquistaDTO conquistaDTO = new ConquistaDTO();

                        conquistaDTO.setIdConquista(rs.getInt("idConquista"));
                        conquistaDTO.setDadoConquista(rs.getDouble("dadoConquista"));
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

    public ConquistaDTO getExibirConquistaById(int idConquista){
        conn = ConnectionFactory.getConnection();
        String query = "SELECT tituloConquista, descricaoConquista FROM conquista WHERE idConquista = ?";
        ConquistaDTO exibirConquista = new ConquistaDTO();
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

    public ConquistaDTO getConquistaById(int idConquista){
        conn = ConnectionFactory.getConnection();
        String query = "SELECT * FROM conquista WHERE idConquista = ?";
        ConquistaDTO conquistaDTO = new ConquistaDTO();
        try ( PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, idConquista);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                conquistaDTO.setIdConquista(idConquista);
                conquistaDTO.setDadoConquista(rs.getDouble("dadoConquista"));
                conquistaDTO.setTipoConquista(rs.getBoolean("tipoConquista"));
                conquistaDTO.setDescricao(rs.getString("descricaoConquista"));
                conquistaDTO.setTitulo(rs.getString("tituloConquista"));

            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsquistaDAO\n" + erro);
        }
        return conquistaDTO;
    }

    public Boolean conquistaExists(int idConquista) {

        String sql = "SELECT * FROM conquista WHERE idConquista = ? ";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idConquista);
            ResultSet resultSet = stmt.executeQuery();
                
                if (resultSet.next()) {
                    return true;
                }

                stmt.close();
                con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        return false;
    }

    public void createConquista(double dadoConquista, Boolean tipoConquista, String tituloConquista, String descricaoConquista) {

        String sql = "INSERT INTO questao VALUES(null, ?, ?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, dadoConquista);
            stmt.setBoolean(2, tipoConquista);
            stmt.setString(3, tituloConquista);
            stmt.setString(4, descricaoConquista);
            stmt.execute();
            
            stmt.close();
            con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
    }

    public void updateConquista(int idConquista, double dadoConquista, Boolean tipoConquista, String tituloConquista, String descricaoConquista) {

        String sql = "UPDATE conquista SET dadoConquista = ?, tipoConquista = ?, tituloConquista = ?, descricaoConquista = ? WHERE idConquista = ?;";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, dadoConquista);
            stmt.setBoolean(2, tipoConquista);
            stmt.setString(3, tituloConquista);
            stmt.setString(4, descricaoConquista);
            stmt.setInt(5, idConquista);
            stmt.execute();
            
            stmt.close();
            con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
}
