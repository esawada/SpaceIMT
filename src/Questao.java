import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questao{
    public int id;
    public String alt1;
    public String alt2;
    public String alt3;
    public String altCorreta;
    public String pergunta;
    public int dificuldade;

    public Questao getQuestaoByID(int idQuestao) {

        String sql = "SELECT * FROM questao WHERE idQuestao = ? ";
        Questao questao = new Questao();
        Connection con = Connector.connect();

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

    public Questao getQuestaoAleatoriaByDificuldade(int dificuldade) {

        String sql = "SELECT * FROM questao WHERE dificuldade = ? ORDER BY rand() LIMIT 1;";
        Questao questao = new Questao();
        Connection con = Connector.connect();

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

        public List<String> getAltEmparalhadas(int dificuldade) {
            Questao questao = new Questao();
            List<String> listaQuestao = new ArrayList<>();
            List<String> alternativas = new ArrayList<>();
            questao = getQuestaoAleatoriaByDificuldade(dificuldade);
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
