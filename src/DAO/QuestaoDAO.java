package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classesObj.Questao;
import dataBase.ConnectionFactory;

public class QuestaoDAO {
    public Questao getQuestaoByID(int idQuestao) {

        String sql = "SELECT * FROM questao WHERE idQuestao = ? ";
        Questao questao = new Questao();
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idQuestao);
            ResultSet resultSet = stmt.executeQuery();
                
                if (resultSet.next()) {
                    questao.setId(resultSet.getInt("idQuestao"));
                    questao.setAlt1(resultSet.getString("alt1"));
                    questao.setAlt2(resultSet.getString("alt2"));
                    questao.setAlt3(resultSet.getString("alt3"));
                    questao.setAltCorreta(resultSet.getString("altCorreta"));
                    questao.setPergunta(resultSet.getString("pergunta"));
                    questao.setDificuldade(resultSet.getInt("dificuldade"));
                }

                stmt.close();
                con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        return questao;
        }

    public static Questao getQuestaoAleatoriaByDificuldade(int dificuldade) {

        String sql = "SELECT * FROM questao WHERE dificuldade = ? ORDER BY rand() LIMIT 1;";
        Questao questao = new Questao();
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, dificuldade);
            ResultSet resultSet = stmt.executeQuery();
                
                if (resultSet.next()) {
                    questao.setId(resultSet.getInt("idQuestao"));
                    questao.setAlt1(resultSet.getString("alt1"));
                    questao.setAlt2(resultSet.getString("alt2"));
                    questao.setAlt3(resultSet.getString("alt3"));
                    questao.setAltCorreta(resultSet.getString("altCorreta"));
                    questao.setPergunta(resultSet.getString("pergunta"));
                    questao.setDificuldade(resultSet.getInt("dificuldade"));
                }

                stmt.close();
                con.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        return questao;
        }

        public static List<String> getAltEmbaralhadas(Questao questao) {
            List<String> listaQuestao = new ArrayList<>();
            List<String> alternativas = new ArrayList<>();
            listaQuestao.add(questao.getPergunta());
            Collections.addAll(alternativas, questao.getAltCorreta(), questao.getAlt1(), questao.getAlt2(), questao.getAlt3());
            Collections.shuffle(alternativas);
            listaQuestao.addAll(alternativas);
            return listaQuestao;
        }

        public Boolean questaoExists(int idQuestao) {

            String sql = "SELECT * FROM questao WHERE idQuestao = ? ";
            Connection con = ConnectionFactory.getConnection();
    
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
    
                stmt.setInt(1, idQuestao);
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

        public void createQuestao(String alt1, String alt2, String alt3, String altCorreta, String pergunta, int dificuldade) {

            String sql = "INSERT INTO questao VALUES(null, ?, ?, ?, ?, ?, ?)";
            Questao questao = new Questao();
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

        public void updateQuestao(int idQuestao, String alt1, String alt2, String alt3, String altCorreta, String pergunta, int dificuldade) {

            String sql = "UPDATE questao SET alt1 = ?, alt2 = ?, alt3 = ?, altCorreta = ?, pergunta = ?, dificuldade = ? WHERE idQuestao = ?;";
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
}
