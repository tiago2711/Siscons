package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;


/**
 *
 * @author Vitor Mesaque
 */
public class UserDao 
{
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }
    
    public void create(User user) {

        try
        {
           String sql = "INSERT INTO usuario (nome, email, senha) VALUES ('"+user.getNome()+"', '"+user.getEmail()+"','"+user.getSenha()+"')";
          
           PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
           stmt.executeUpdate(); 
           
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
        
    }
    
    public ArrayList<User> list() {

        try
        {
            String sql = "SELECT * FROM usuario ORDER BY id";
            
            Statement stmt = this.connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList<User> users = new ArrayList();
            
            while(rs.next())   
            {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                
                user.setNome(rs.getString("name"));
                
                user.setEmail(rs.getString("email"));
                
                users.add(user);
            }
            
            return users;
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
        
        return null;
    }
    
    public void update(User user)
    {
        try
        {
           String sql = "UPDATE usuario SET name = '"+user.getNome()+"', email = '"+user.getEmail()+"', profile = '"+user.getSenha()+"' WHERE id = " + user.getId();
          
           PreparedStatement stmt = this.connection.prepareStatement(sql);
           
           stmt.executeUpdate();
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
    }
    
    public Boolean delete(int id)
    {
        try
        {
           String sql = "DELETE FROM usuario WHERE id = " + id;
           
           Statement stmt = this.connection.createStatement();
           
           stmt.executeQuery(sql); 
           
           return true;
          
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
        return false;
    }
  
    public User getById(int id) {

        try
        {
            String sql = "SELECT * FROM usuario WHERE id = " + id;
            
            Statement stmt = this.connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next())   
            {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                
                user.setNome(rs.getString("name"));
                
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
    
    
    public void updatePass(User user) {
        try
        {
           String sql = "UPDATE usuario SET password = '"+user.getSenha()+"' WHERE id = " + user.getId();
          
           PreparedStatement stmt = this.connection.prepareStatement(sql);
           
           stmt.executeUpdate();
          
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
    }
}