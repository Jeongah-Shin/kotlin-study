package jeongari.com.kotlin_study.java_dto_concepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaDao {

    public void add(JavaMember javaMember) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

        PreparedStatement preparedStatement = connection.prepareStatement("insert into memberrs(name,password) value(?,?)");


        preparedStatement.setString(1, javaMember.getName());
        preparedStatement.setString(2, javaMember.getEmail());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.close();

    }
}