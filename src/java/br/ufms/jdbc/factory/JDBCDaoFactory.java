
package br.ufms.jdbc.factory;

import Dao.AuthenticateDao;
import Dao.DaoFactory;
import Dao.ServidorDao;
import Dao.UserDao;
import java.sql.Connection;
import java.sql.SQLException;
import util.ConnectionFactory;

/**
 *
 * @author Vitor Mesaque
 */
 
public class JDBCDaoFactory extends DaoFactory{

    private Connection connection;

    public JDBCDaoFactory() 
    {
        try
        {
            this.connection =  ConnectionFactory.getConnection() ;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public UserDao getUserDao() 
    {
        return new UserDao(this.connection);
    }
       
    @Override
    public AuthenticateDao getAuthenticateDao() 
    {
        return new AuthenticateDao(this.connection);
    }

    @Override
    public ServidorDao getServidorDao() {
         return new ServidorDao(this.connection);
    }
      
}