public class Função_Conquista{
    private static class Conquista {
        private int nível = 1;
        
        public int getNível() {
            return nível;
        }

        public void setNível(int nível) {
            this.nível = nível;
        }

        @Override
        public String toString() {
            return "Conquista{" +"nível=" + nível +'}';
        }
    }

    public static void main(String[] args) {
        Conquista conquista = new Conquista();

        for (int i = 0; i < 10; i++) {
            Conquista.setNível(Conquista.getNível() + 1);
        }

    }
}