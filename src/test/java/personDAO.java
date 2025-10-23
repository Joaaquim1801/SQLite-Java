import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class personDAO {
    // DAO = Data Acess Object
    // Serve basicamente para ser uma classe que possui os métodos principais do banco de dados
    private Connection connection;

    public personDAO() {
        connection = dataBase.getINSTANCE().getConnection();
    }

    public void insert(person person) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into person values(" + person.getId() + ",'" + person.getName() + "')");
        statement.close();
    }

    public void delete(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from person where person.id =" + id);
        statement.close();
    }

    public List<person> getAll() throws SQLException {

        List<person> persons = new ArrayList<person>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from person");
        while (rs.next())
        {
            person p = new person();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            persons.add(p);
        }

        statement.close();
        return persons;
    }

    public person getById(int id) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from person where person.id =" + id);

        if (rs.next()){
            person p = new person();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            return p;
        }
        statement.close();
        return null;
    }

    public void update(person p, int id) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "update person set name = '" + p.getName() +
                        "', id = " + p.getId() +
                        " where person.id = " + id);
        statement.close();
    }
}
