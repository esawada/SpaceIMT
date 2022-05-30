package classesObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dataBase.ConnectionFactory;

public class Questao{
    private int id;
    private String alt1;
    private String alt2;
    private String alt3;
    private String altCorreta;
    private String pergunta;
    private int dificuldade;

    public String getAltCorreta() {
        return this.altCorreta;
    }

    public Questao getQuestaoByID(int idQuestao) {

        String sql = "SELECT * FROM questao WHERE idQuestao = ? ";
        Questao questao = new Questao();
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idQuestao);
            ResultSet resultSet = stmt.executeQuery();
                
                if (resultSet.next()) {
                    questao.id = resultSet.getInt("idQuestao");
                    questao.alt1 = resultSet.getString("alt1");
                    questao.alt2 = resultSet.getString("alt2");
                    questao.alt3 = resultSet.getString("alt3");
                    questao.altCorreta = resultSet.getString("altCorreta");
                    questao.pergunta = resultSet.getString("pergunta");
                    questao.dificuldade = resultSet.getInt("dificuldade");
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
                    questao.id = resultSet.getInt("idQuestao");
                    questao.alt1 = resultSet.getString("alt1");
                    questao.alt2 = resultSet.getString("alt2");
                    questao.alt3 = resultSet.getString("alt3");
                    questao.altCorreta = resultSet.getString("altCorreta");
                    questao.pergunta = resultSet.getString("pergunta");
                    questao.dificuldade = resultSet.getInt("dificuldade");
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
            listaQuestao.add(questao.pergunta);
            Collections.addAll(alternativas, questao.altCorreta, questao.alt1, questao.alt2, questao.alt3);
            Collections.shuffle(alternativas);
            listaQuestao.addAll(alternativas);
            return listaQuestao;
        }

        public boolean checarSeAlternativaCorreta(String alternativa) {
            if (alternativa.equals(this.altCorreta)){
                return true;
            } else {
                return false;
            }
        }
}
