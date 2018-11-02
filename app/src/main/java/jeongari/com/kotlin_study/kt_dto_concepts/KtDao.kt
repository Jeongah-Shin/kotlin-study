package jeongari.com.kotlin_study.kt_dto_concepts

import java.sql.DriverManager
import java.sql.SQLException

class KtDao {
    @Throws(ClassNotFoundException::class, SQLException::class)
    fun add(ktDtoMember :KtDtoMember) {
        Class.forName("com.mysql.jdbc.Driver")
        val connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root")

        val preparedStatement = connection.prepareStatement("insert into members(name,email) value(?,?)")


        preparedStatement.setString(1, ktDtoMember.name)
        preparedStatement.setString(2, ktDtoMember.email)
        preparedStatement.executeUpdate()
        preparedStatement.close()

        connection.close()

    }
}