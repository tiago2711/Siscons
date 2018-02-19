package business;

import Dao.DaoFactory;
import Dao.ServidorDao;
import Dao.UserDao;
import java.util.ArrayList;
import model.Servidor;
import model.User;
import util.Md5;

/**
 *
 * @author Vitor Mesaque
 */
public class ServidorBO {

    public void insertUser(Servidor servidor) {
        ServidorDao servidorDao = DaoFactory.getDaoFactory().getServidorDao();

        servidorDao.create(servidor);
    }

    public Servidor getServidor(int siape,String categoria){
        ServidorDao servidorDao = DaoFactory.getDaoFactory().getServidorDao();

        return servidorDao.getServidor(siape,categoria);
    }

    public  ArrayList<Servidor> getServidores(int siape,String nome,String categoria) 
    {
        ServidorDao servidorDao = DaoFactory.getDaoFactory().getServidorDao();

        return servidorDao.getServidores(siape,nome,categoria);
    }

    public void updateServidor(Servidor servidor) 
    {
        ServidorDao servidorDao = DaoFactory.getDaoFactory().getServidorDao();

        servidorDao.update(servidor);
    }
    
    public  ArrayList<Servidor> getRelatorio(String tabela){
        ServidorDao servidorDao = DaoFactory.getDaoFactory().getServidorDao();
        
        return servidorDao.getRelatorio(tabela);
    }
}
