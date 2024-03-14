package estm.dsic.jee.dal;



import estm.dsic.jee.models.Contact;
import estm.dsic.jee.models.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
@Transactional
public class ContactDao {

    @PersistenceContext(name = "contacte")
    private EntityManager em;

    // Insert
    public void create(Contact contact) {
        em.persist(contact);
    }

    // Remove
    public void removeContact(int id) {
        Contact contact = em.find(Contact.class, id);
        if (contact != null) {
            em.remove(contact);
        }
    }

    // Get all contacts for a user
    public List<Contact> getContacts(User user) {
        Query query = em.createQuery("SELECT c FROM Contact c WHERE c.user.id = :user_id");
        query.setParameter("user_id", user.getId());
        return query.getResultList();
    }

    // Update
    public void updateUser(Contact contact) {
        Contact existingContact = em.find(Contact.class, contact.getId());
        if (existingContact != null) {
            existingContact.setNom(contact.getNom());
            existingContact.setTel(contact.getTel());
            existingContact.setEmail(contact.getEmail());
            existingContact.setAddress(contact.getAddress());
            // If you want to update the user as well, uncomment the next line
            // existingContact.setUser(contact.getUser());
            em.merge(existingContact);
        }
    }
}
