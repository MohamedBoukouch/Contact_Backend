package estm.dsic.jee.controllers;

import java.util.List;

import estm.dsic.jee.business.IUserServices;
import estm.dsic.jee.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class AuthController {
    @Inject
     IUserServices userServices;

    @Path("/login")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

     public User login(@FormParam("login") String login,@FormParam("password") String password){
         return userServices.auth( login); 
     }
     
     @Path ("/signup")
     @POST 
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public boolean signup(@FormParam("login") String login,@FormParam("password") String password,@FormParam("isVerify") int isVerify,@FormParam("isAdmin") int isAdmin){

            User user=new User();
            user.setIsAdmin(isAdmin);
            user.setIsVerify(isVerify);
            user.setLogin(login);
            user.setPassword(password);
             return userServices.create(user);
        }


    //Valider User
     @Path ("/validerUser")
     @POST 
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public boolean validerUser(@FormParam("user_id") int user_id){

            User user=new User();
            user.setId(user_id);
            user.setIsVerify(1);

             return userServices.validereUser(user);
        }

    //Desactive User
    @Path ("/desactiveUser")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
       public boolean desactiveUser(@FormParam("user_id") int user_id){

           User user=new User();
           user.setId(user_id);
           user.setIsVerify(0);

            return userServices.desactiveUser(user);
    }

    //SELECT
    @Path("/selectusers")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
     public  List<User> SelectAllUsers(){

    return userServices.getAllUsers();
    }


    //DeletUser
    @Path ("/deletUser")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean deletUser(@FormParam("user_id") int user_id){

        User user=new User();
        user.setId(user_id);
        return userServices.deleteUser(user);
    }



}
