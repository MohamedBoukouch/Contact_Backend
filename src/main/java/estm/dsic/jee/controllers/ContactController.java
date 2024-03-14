package estm.dsic.jee.controllers;

import java.util.List;

import estm.dsic.jee.business.IContactServices;
import estm.dsic.jee.business.IUserServices;
import estm.dsic.jee.models.Contact;
import estm.dsic.jee.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/contact")
public class ContactController {

    @Inject
    IContactServices contactServices;

    @Path("/addcontact")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

     public boolean Addcontact(@FormParam("nom") String nom,@FormParam("tel") String tel,@FormParam("email") String email,@FormParam("addresse") String addresse,@FormParam("userId") int userId){

        Contact contact=new Contact();
        contact.setNom(nom);
        contact.setTel(tel);
        contact.setEmail(email);
        contact.setAddress(addresse);  
        
        User user = new User();
            user.setId(userId); // Assuming you have a setId method in your User class
            contact.setUser(user);
        return contactServices.create(contact); 
     }




      @Path("/deletcontact")
         @POST 
         @Produces(MediaType.APPLICATION_JSON)
         @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     
          public boolean Deletcontact(@FormParam("notId") int notId){
     
             Contact contact=new Contact();
             contact.setId(notId); 


             return contactServices.delete(contact); 
          }


        //SELECT
        @Path("/selectcontact")
         @POST 
         @Produces(MediaType.APPLICATION_JSON)
         @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
          public  List<Contact> Selectontact(@FormParam("userid") int userid){

            Contact contact=new Contact();

            User user=new User();
            user.setId(userid);

             // Assuming you have a setId method in your User class
                contact.setUser(user); 


             return contactServices.getContact(contact);
          }
        

    //SELECT
        @Path("/update")
         @POST 
         @Produces(MediaType.APPLICATION_JSON)
         @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
          public  boolean Updatetontact(@FormParam("nom") String nom,@FormParam("tel") String tel,@FormParam("email") String email,@FormParam("addresse") String addresse,@FormParam("contactId") int contactId){

            Contact contact=new Contact();
                    contact.setNom(nom);
                    contact.setTel(tel);
                    contact.setEmail(email);
                    contact.setAddress(addresse);  
                    contact.setId(contactId);  

             return contactServices.update(contact);
          }

        
}
