package estm.dsic.jee.dal;


import java.util.List;
import estm.dsic.jee.models.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Named
@RequestScoped
@Transactional
public class UserDao {

    @PersistenceContext(name = "contacte")
    private EntityManager em;

    // Insert
    public void create(User u) {
        em.persist(u);
    }

    // Valid user
    public void validereUser(User user) {
        User u = em.find(User.class, user.getId());
        if (u != null) {
            u.setIsVerify(user.getIsVerify());
            em.merge(u);
        }
    }

    // Valid user
    public void DesactiveUser(User user) {
        User u = em.find(User.class, user.getId());
        if (u != null) {
            u.setIsVerify(user.getIsVerify());
            em.merge(u);
        }
    }

    // Remove
    public void removeUser(int user_id) {
        User u = em.find(User.class, user_id);
        if (u != null) {
            em.remove(u);
        }
    }

    // Select
    public List<User> getAllUsers() {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }

    // Find user by email
    public User login(String email){
      String queryString = "SELECT u FROM User u WHERE u.login = :email";
      Query query = em.createQuery(queryString, User.class);
      query.setParameter("email", email);

      List<User> userList = query.getResultList();

      if (!userList.isEmpty()) {
          return userList.get(0); // Return the first user with the specified email
      }
      return null; // Return null if no user is found
  }
}
