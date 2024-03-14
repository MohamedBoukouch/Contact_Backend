package estm.dsic.jee.business;


import java.util.List;

import estm.dsic.jee.models.Contact;
import estm.dsic.jee.models.User;


public interface IContactServices {

     boolean create(Contact contact);
     boolean delete(Contact contact);
     boolean update(Contact contact);
     List<Contact> getContact(Contact contact);
    
} 
