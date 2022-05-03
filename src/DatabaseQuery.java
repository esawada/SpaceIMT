import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseQuery {
    public static Connection connect() {
        
    String url = "jdbc:mysql://localhost:3306";
    String username = "root";
    String password = "";
    Connection conn = null;
    
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    public static void main(String[] args) {
        String sql1 = "create database spaceimt;";
        String sql2 = "use spaceimt;";
        String sql3 = "CREATE TABLE usuario (idUsuario INTEGER UNIQUE, senha VARCHAR(100), email VARCHAR(100) UNIQUE, nickname VARCHAR(30) UNIQUE, tipo BOOL, nivel DOUBLE, numeroFase INTEGER, CONSTRAINT PK_Usuario PRIMARY KEY (idUsuario));";
        String sql4 = "CREATE TABLE conquista (idConquista INTEGER UNIQUE, numeroPerguntas integer, tipoConquista bool, valor INTEGER NOT NULL, CONSTRAINT PK_Conquista PRIMARY KEY (idConquista));";
        String sql5 = "CREATE TABLE questao (idQuestao INTEGER UNIQUE, alt1 VARCHAR(50), alt2 VARCHAR(50), alt3 VARCHAR(50), altCorreta VARCHAR(50), pergunta VARCHAR(50), dificuldade INTEGER, CONSTRAINT PK_Questao PRIMARY KEY (idQuestao));";
        String sql6 = "CREATE TABLE usuarioConquista (idUsuario INTEGER NOT NULL, idConquista INTEGER NOT NULL, FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario), FOREIGN KEY (idConquista) REFERENCES conquista (idConquista));";
        Connection con = Connector.connect();
        try (PreparedStatement stmt = con.prepareStatement(sql1)) {
            PreparedStatement stmt1 = con.prepareStatement(sql2);
            PreparedStatement stmt2 = con.prepareStatement(sql3);
            PreparedStatement stmt3 = con.prepareStatement(sql4);
            PreparedStatement stmt4 = con.prepareStatement(sql5);
            PreparedStatement stmt5 = con.prepareStatement(sql6);
            stmt.executeQuery();
            stmt1.executeQuery();
            stmt2.executeQuery();
            stmt3.executeQuery();
            stmt4.executeQuery();
            stmt5.executeQuery();
            stmt.close();
            stmt1.close();
            stmt2.close();
            stmt3.close();
            stmt4.close();
            stmt5.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

