package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    // Variável que especifica o uso do banco de dados MySQL:
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    // Variável do caminho de conexão até nosso banco de dados:
    public static final String URL = "jdbc:mysql://localhost:3306/taskminder";
    // Variável que especifica qual usuário será usado:
    public static final String USER = "root";
    // Variável de senha:
    public static final String PASS = "";
   
    // Retorna uma conexão:
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados: ", ex);
        }
    }
}