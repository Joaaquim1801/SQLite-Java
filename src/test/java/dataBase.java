import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dataBase {
    private Connection connection;
    private static dataBase INSTANCE = null;
    // Isso garante que haja uma única conexão

    private dataBase() {
        try{
            this.connection = DriverManager.getConnection("jdbc:sqlite:persons.db");

            // jdbc -> usado para, a partir do sqlite, criar e abrir o arquivo sample.db
            Statement statement = connection.createStatement();
            // Crie um `comando` para rodar o SQL, a connection sozinha não executa

            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            String sql = fileUtils.carregarArquivoTexto("src/test/instructions.sql");

            statement.executeUpdate(sql);

        }
        //Tinha dado esse erro, o problema era que eu coloquei Connection connection, isso fez que com que eu criasse uma outra variável
        //Dentro do construtor
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.sql.Connection.createStatement()" because "connection" is null at testeDB.main(testeDB.java:18)
        catch (SQLException e){
            System.err.println("Houve um erro na criação do arquivo");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static dataBase getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new dataBase();
        }
        return INSTANCE;
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.err.println("Houve um erro ao fechar a conexão com o banco");
            throw new RuntimeException(e);
        }
    }

}
