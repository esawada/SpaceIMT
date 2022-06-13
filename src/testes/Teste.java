package testes;

import DAO.ConquistaDAO;
import DAO.EdicaoDAO;
import classesObj.Questao;

public class Teste {
    public static void main(String[] args) {
        // Questao questao = new Questao(); 
        // System.out.println(questao.getQuestaoByID(1).pergunta);
        // System.out.println(questao.getQuestaoAleatoriaByDificuldade(0).pergunta);
        // System.out.println(questao.getAltEmbaralhadas(0));
        // EdicaoDAO edicaoDAO = new EdicaoDAO();
        // edicaoDAO.criarConquista(1, false, "Conquista teste", "descricao teste");
        // edicaoDAO.criarQuestao("alt1", "alt2", "alt3", "altCorreta", "teste", 0);
        ConquistaDAO conquistaDAO = new ConquistaDAO();
        System.out.println(conquistaDAO.ListarConquistaUsuarioNaoLiberadas(1, true));
    }
}
