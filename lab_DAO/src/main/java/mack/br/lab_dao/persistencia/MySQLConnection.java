
package mack.br.lab_dao.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    String db = "aula_dao";
    String url = "jdbc:mysql://localhost:3306/" + db + "?useUnicode=true&useJDBCCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String usuario = "root";
    String senha = "";
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,usuario,senha);
        } catch(final Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
