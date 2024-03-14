package estm.dsic.jee.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Contact {
    
        // private static final long serialVersionUID = 1L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
    
        @Column
        private String nom;
    
        @Column
        private String tel;
    
        @Column
        private String email;
    
        @Column
        private String address;

        // @Column
        // private int user_id;
    
        @ManyToOne
        @JoinColumn(name = "user_id") 
        private User user;
       
       
        //    public static long getSerialversionuid() {
        //        return serialVersionUID;
        //    }

            public int getId() {
                return id;
            }
        
            public void setId(int id) {
                this.id = id;
            }
            
           public String getNom() {
               return nom;
           }
           public void setNom(String nom) {
               this.nom = nom;
           }
           public String getTel() {
               return tel;
           }
           public void setTel(String tel) {
               this.tel = tel;
           }
           public String getEmail() {
               return email;
           }
           public void setEmail(String email) {
               this.email = email;
           }
           public String getAddress() {
               return address;
           }
           public void setAddress(String addresse) {
               this.address = addresse;
           }
            public User getUser() {
                return user;
            }
        
            public void setUser(User user) {
                this.user = user;
            }
       
       
}
