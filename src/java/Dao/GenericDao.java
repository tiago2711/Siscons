
package Dao;

import java.util.ArrayList;
import model.User;

/**
 *
 * @author Vitor Mesaque
 */
public interface GenericDao<Type> {
    
    
    public void save (Type obj);
    
    public void update (Type obj);
    
    public Boolean delete (int id);
    
    public ArrayList<Type> list ();
    
    public Type getById (int id);

    public void updatePass(User user);

}

