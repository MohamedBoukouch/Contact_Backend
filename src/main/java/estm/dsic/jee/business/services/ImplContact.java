package estm.dsic.jee.business.services;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.business.IContactServices;
import estm.dsic.jee.business.IUserServices;
import estm.dsic.jee.dal.ContactDao;
import estm.dsic.jee.dal.UserDao;
import estm.dsic.jee.models.Contact;
import estm.dsic.jee.models.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@SessionScoped
public class ImplContact implements IContactServices,Serializable{

        @Inject
        private ContactDao contactDao;

        @Override
        public boolean create(Contact contat) {
            // TODO Auto-generated method stub
            contactDao.create(contat);
            return true;
        }

        @Override
        public boolean delete(Contact note) {
            // TODO Auto-generated method stub
           contactDao.removeContact(note.getId());
            return true;
        }

       @Override
        public List<Contact> getContact(Contact contact) {
            return contactDao.getContacts(contact.getUser());
        }

    @Override
    public boolean update(Contact contact) {
        // TODO Auto-generated method stub
       contactDao.updateUser(contact);
        return true;
    }
    
}
