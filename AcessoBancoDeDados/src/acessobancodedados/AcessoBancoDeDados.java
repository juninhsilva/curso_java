/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessobancodedados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * URL de Bancos de dados
 * em geral: protocolo:subprotocolo:endereço do servidor:porta/nome do banco
 * DB2          - jdbc:db2:servidor:porta/banco
 * Oracle       - jdbc:oracle:thin:@servidor:porta:banco
 * PostgreSQL   - jdbc:postgresql://servidor:porta/banco
 * SQLServer    - jdbc:sqlserver://servidor:porta;database
 * MySQL        - jdbc:mysql://servidor:porta/banco
 * Java DB      - jdbc:derby://servidor:porta/banco
 * Sybase       - jdbc:sybase:Tds:servidor:porta/banco
 * 
 * @author junior
 */
public class AcessoBancoDeDados {
    private static final Logger LOG = Logger.getLogger(AcessoBancoDeDados.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String urlBancoDeDados = "jdbc:mysql://localhost:3306/xti";
        String sql = "SELECT * FROM Pessoa";
        try (Connection connection = DriverManager.getConnection(urlBancoDeDados, "xti", "123");){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                System.out.println("Código: "+ resultSet.getInt("codigo") + " - Nome: " + resultSet.getString("nome"));
            }
        } catch (Exception e) {
        }
    }
}
