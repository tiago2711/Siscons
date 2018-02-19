package business;

import Dao.DaoFactory;
import Dao.UserDao;
import java.util.ArrayList;
import model.User;
import util.Md5;

/**
 *
 * @author Vitor Mesaque
 */
public class UserBO {

    public void insertUser(User user) {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();

        user.setSenha(Md5.encrypt(user.getSenha()));

        userDao.create(user);
    }

    public ArrayList<User> getAllUsers() {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();

        return userDao.list();
    }

    public User getUser(int id) 
    {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();

        return userDao.getById(id);
    }

    public void updateUser(User user) 
    {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();

        userDao.update(user);
    }

    public void updatePass(User user) 
    {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();
        
        user.setSenha(Md5.encrypt(user.getSenha()));
        
        userDao.updatePass(user);
    }
}
