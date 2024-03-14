package estm.dsic.jee.business;


import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.dal.UserDao;
import estm.dsic.jee.models.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ImplUserServices implements IUserServices, Serializable {

    @Inject
    private UserDao userDao;

    @Override
    public User auth(String user) {
       // return userDao.auth(user);
       return userDao.login(user);
    }

    @Override
    public boolean create(User user) {
         userDao.create(user);
         return true;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public boolean deleteUser(User user) {
        userDao.removeUser(user.getId());
        return true;
    }

    @Override
    public boolean updateUser(User user, String email) {
          // return userDao.update(user, email);
          return false;
    }

   

    @Override
    public List<User> searchUserByEmail(User user) {
        // return userDao.searchUserByEmail(user.getEmail());
        return null;
    }

    @Override
    public boolean validereUser(User user) {
        userDao.validereUser(user);
        return true;
    }

    @Override
    public boolean desactiveUser(User user) {
        userDao.DesactiveUser(user);
        return true;
    }

}
