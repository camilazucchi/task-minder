package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {
    
    // Vari�vel que especifica o uso do banco de dados MySQL:
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    // Vari�vel do caminho de conex�o at� nosso banco de dados:
    public static final String URL = "jdbc:mysql://localhost:3306/taskminder";
    // Vari�vel que especifica qual usu�rio ser� usado:
    public static final String USER = "root";
    // Vari�vel de senha:
    public static final String PASS = "";
    
    // M�todos:
    // Retorna uma conex�o:
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conex�o com o banco de dados", ex);
        }
    }
    
    
}