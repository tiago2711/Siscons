
package business;

import Dao.AuthenticateDao;
import Dao.DaoFactory;
import model.User;
import util.Md5;



/**
 *
 * @author Vitor Mesaque
 */

public class AuthenticateBO 
{
    public User logon(String email, String password)
    {
        AuthenticateDao authenticateDao = DaoFactory.getDaoFactory().getAuthenticateDao();
        
        return authenticateDao.authenticate(email, Md5.encrypt(password));
    }
}
