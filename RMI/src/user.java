
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
public class user implements Serializable {
    private static final long serialVersionUID = 7530713031723732448L;

    private Long id;    
    private String nom;
    private String prenom;
    private String cne;
    private String password;
    private String dateNaissance;
    private String role;
    public user(){
        
    }

    public user(String nom, String prenom, String cne, String password, String dateNaissance, String role) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.role = role;
        
    }
    

    // Constructeur, getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

