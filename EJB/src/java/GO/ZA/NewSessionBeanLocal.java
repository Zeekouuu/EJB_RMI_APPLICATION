/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package GO.ZA;


import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author zeekouu
 */
@Remote
public interface NewSessionBeanLocal {
    void enregistrerUser(user u);
    void enregistrerCours(cours cr);
    void enregistrerNote(note n);
    void enregistrer(perso p);
     void deposerCours(cours cour);
     void saisirNote(user etudiant, note note);
     void modifierNote(user etudiant, note note);
     void UpdateNote(double nt,String etudiant,Long id);
     void editerNotes();
     List<user> consulterUtediant();
     List<note> consulterNotes(user etudiant);
     List<cours> consulterCours();
     List<user> consulterEnseignant();

     user findUtilisateurByUsernameAndPassword(String cne, String password);
     user selectuserByID(Long id);
     note selectionerNote(String module,String etudiant);
     String TelechargerCours(String titre , String enseignant);
    
}
