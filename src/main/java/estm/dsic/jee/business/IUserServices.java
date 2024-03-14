package estm.dsic.jee.business;

import java.util.List;

import estm.dsic.jee.models.User;


public interface IUserServices  {

    User auth(String user);
    boolean create(User user);
    boolean validereUser(User user);
    boolean desactiveUser(User user);
    boolean deleteUser(User user);
    List<User> getAllUsers();


    boolean updateUser(User user, String email);
    
    List<User>searchUserByEmail(User user);

}
