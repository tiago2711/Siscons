package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;
import util.Md5;

/**
 *
 * @author Vitor Mesaque
 */
public class AuthenticateDao 
{
    private Connection connection;

    public AuthenticateDao(Connection connection) {
        this.connection = connection;
    }
    
   public User authenticate(String email, String senha) {

       try
        {
            String sql = "SELECT * FROM usuario WHERE email = '" + email + "' AND senha = '"+ Md5.encrypt(senha) + "'" ;
            
            Statement stmt = this.connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next())   
            {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                
                user.setNome(rs.getString("nome"));
                
                user.setEmail(rs.getString("email"));
                
                return user;
            }
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
        
        return null;
    }
}