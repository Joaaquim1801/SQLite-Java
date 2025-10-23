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

            Statement statement = connection.createStatement();

            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            String sql = fileUtils.loadTextFile("src/test/instructions.sql");

            statement.executeUpdate(sql);

        }
        catch (SQLException e){
            System.err.println("There was an error creating the file");
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
            System.err.println("There was an error closing the connection to the database");
            throw new RuntimeException(e);
        }
    }

}
