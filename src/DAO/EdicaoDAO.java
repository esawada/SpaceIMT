package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dataBase.ConnectionFactory;

public class EdicaoDAO {

    public void editarConquista(int idConquista, int dadoConquista, String tituloConquista, String descricaoConquista) {

        String sql = "UPDATE conquista SET dadoConquista = ? tituloConquista = ? descricaoConquista = ? WHERE idConquista = ?";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, dadoConquista);
            stmt.setString(2, tituloConquista);
            stmt.setString(3, descricaoConquista);
            stmt.setInt(4, idConquista);
            stmt.execute();

            stmt.close();
            con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
    public void criarConquista(int dadoConquista, boolean tipoConquista, String tituloConquista, String descricaoConquista) {

        String sql = "insert into conquista values(null, ?, ?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, dadoConquista);
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
        public void editarQuestao(int idQuestao, String alt1, String alt2 , String alt3, String altCorreta, String pergunta, int dificuldade ) {

            String sql = "UPDATE questao SET alt1 = ? alt2 = ? alt3 = ? altCorreta = ? pergunta = ? dificuldade = ? WHERE idConquista = ?";
            Connection con = ConnectionFactory.getConnection();
    
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, alt1);
                stmt.setString(2, alt2);
                stmt.setString(3, alt3);
                stmt.setString(4, altCorreta);
                stmt.setString(5, pergunta);
                stmt.setInt(6, dificuldade);
                stmt.setInt(7, idQuestao);
                stmt.execute();
    
                stmt.close();
                con.close();
                } catch (Exception e) {
                e.printStackTrace();
                }
            }
        public void criarQuestao(String alt1, String alt2, String alt3, String altCorreta, String pergunta, int dificuldade) {
    
            String sql = "insert into questao values(null, ?, ?, ?, ?, ?, ?)";
            Connection con = ConnectionFactory.getConnection();
    
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, alt1);
                stmt.setString(2, alt2);
                stmt.setString(3, alt3);
                stmt.setString(4, altCorreta);
                stmt.setString(5, pergunta);
                stmt.setInt(6, dificuldade);
                stmt.execute();
    
                stmt.close();
                con.close();
                } catch (Exception e) {
                e.printStackTrace();
                }
            }
}