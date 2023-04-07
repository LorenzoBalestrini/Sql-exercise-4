import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun main(){

     var connection : Connection? = null
     try{

         val url = "jdbc:mysql://localhost:3306/newdb"
         val user = "developer"
         val password = "1234"

         connection = DriverManager.getConnection(url, user, password)
         val statement = connection.createStatement()
         val resultSet = statement.executeQuery("select * from students")
         val addCountry = "ALTER TABLE students ADD country VARCHAR(30) NULL DEFAULT NULL"
         val updateCountryItaly = "update students set country='Italia' where student_id=1 or student_id=2"
         val updateCountryGermany = "update students set country='Germania' where student_id=3 or student_id=4"
         statement.executeUpdate(addCountry)
         statement.executeUpdate(updateCountryItaly)
         statement.executeUpdate(updateCountryGermany)

         println(resultSet)

     }catch (e: SQLException){
         println(e.message)
     } finally {
         try {
             connection?.close()
         }catch (ex: SQLException) {
             println(ex.message)
         }
     }
 }