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
}
