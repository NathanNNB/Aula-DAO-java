package mack.br.lab_dao;
import mack.br.lab_dao.persistencia.contasDaoMySQL;
import java.sql.*;
public class App {
    public static void main( final String[] args ){
        contasDaoMySQL mysqlDAO = new contasDaoMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}
