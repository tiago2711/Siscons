package Dao;

import br.ufms.jdbc.factory.JDBCDaoFactory;

/**
 *
 * @author Vitor Mesaque
 */


public abstract class DaoFactory {

    public static DaoFactory getDaoFactory() {
        return new JDBCDaoFactory();
    }

    public abstract UserDao getUserDao();  
    
    public abstract AuthenticateDao getAuthenticateDao();
    
    public abstract ServidorDao getServidorDao();
}
