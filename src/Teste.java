public class Teste {
    public static void main(String[] args) {
        Questao questao = new Questao(); 
        System.out.println(questao.getQuestaoByID(1).pergunta);
        System.out.println(questao.getQuestaoAleatoriaByDificuldade(0).pergunta);
        System.out.println(questao.getAltEmparalhadas(0));

        
    }
}
