package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        } catch(ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conex�o com o banco de dados: ", ex);
        }
    }
    
    // Fecha a conex�o com o banco de dados:
    public static void closeConnection(Connection connection) {
        try {
            // Essa conex�o existe? Se diferente de null = sim. Feche a conex�o com connection.close:
            if (connection != null) {
                connection.close();
            }
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados: ", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            // Essa conex�o existe? Se diferente de null = sim. Feche a conex�o com connection.close:
            if(connection != null) {
                connection.close();
            }
            
            if(statement != null) {
                statement.close();
            }
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados: ", ex);
        }
    }
}