/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package GO.ZA;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author zeekouu
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {
      @PersistenceContext
    private EntityManager entityManager;
@Override
    public void enregistrerUser(user u) {
    
         entityManager.persist(u); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void enregistrer(perso p) {
    
         entityManager.persist(p); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      @Override
      public void deposerCours(cours cour) {
        // Logique pour enregistrer le cours dans la base de données
    }

      @Override
    public void saisirNote(user etudiant, note note) {
        // Logique pour enregistrer la note de l'étudiant dans la base de données
    }

      @Override
    public void modifierNote(user etudiant, note note) {
        // Logique pour modifier la note de l'étudiant dans la base de données
    }

      @Override
    public List<note> consulterNotes(user etudiant) {
        String jpql = "SELECT n FROM note n WHERE n.etudiant = :etud AND n.reponse='1'";
        TypedQuery<note> query =  entityManager.createQuery(jpql, note.class);
        query.setParameter("etud", etudiant.getNom()+" "+etudiant.getPrenom());
          System.out.println(query);
      
        // Logique pour récupérer les notes de l'étudiant depuis la base de données
        List<note> listeNotes = query.getResultList();
        return listeNotes;
       
    }
    
      
      @Override
      public user findUtilisateurByUsernameAndPassword(String cne, String password) {
        String jpql = "SELECT u FROM user u WHERE u.cne = :cne AND u.password = :password";
        TypedQuery<user> query =  entityManager.createQuery(jpql, user.class);
        query.setParameter("cne", cne);
        query.setParameter("password", password);
        user u = query.getSingleResult();
        System.out.println(u.getNom());
        return query.getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public user selectuserByID(Long id) {
            String jpql = "SELECT u FROM user u WHERE u.id = :id ";
        TypedQuery<user> query =  entityManager.createQuery(jpql, user.class);
        query.setParameter("id", id);
        user u = query.getSingleResult();
        System.out.println(u.getNom());
        return query.getSingleResult();// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void enregistrerCours(cours cr) {
        entityManager.persist(cr); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<user> consulterUtediant() {
         List<user> etudiants = entityManager.createQuery("SELECT u FROM user u WHERE u.role = 'etudiant'", user.class)
                .getResultList();

        return etudiants; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void enregistrerNote(note n) {
      entityManager.persist(n);  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public note selectionerNote(String module, String etudiant) {
        String jpql = "SELECT n FROM note n WHERE n.module = :module AND n.etudiant = :etudiant";
        TypedQuery<note> query =  entityManager.createQuery(jpql, note.class);
        query.setParameter("module", module);
        query.setParameter("etudiant", etudiant);
        note n = query.getSingleResult();
       
        return query.getSingleResult(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  @Override
public void UpdateNote(double nt, String etudiant , Long id) {
    String jpql = "UPDATE note n SET n.valeur = :nt WHERE n.etudiant = :etudiant AND n.id = :id";
    TypedQuery<Void> query = (TypedQuery<Void>) entityManager.createQuery(jpql);
    query.setParameter("nt", nt);
    query.setParameter("etudiant", etudiant);
    query.setParameter("id", id);
    query.executeUpdate();
}

    @Override
    public String TelechargerCours(String titre, String enseignant) {
        String jpql = "SELECT c.contenue FROM cours c WHERE c.titre = :titre AND c.enseignant = :enseignant";
        TypedQuery<String> query =  entityManager.createQuery(jpql, String.class);
        query.setParameter("titre", titre);
        query.setParameter("enseignant", enseignant);
        String n = query.getSingleResult();
       
        return query.getSingleResult(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<cours> consulterCours() {
        List<cours> cours = entityManager.createQuery("SELECT c FROM cours c ", cours.class)
    
               .getResultList(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
return cours;    }

    @Override
    public List<user> consulterEnseignant() {
           List<user> etudiants = entityManager.createQuery("SELECT u FROM user u WHERE u.role = 'enseignant'", user.class)
                .getResultList();

        return etudiants;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
      @Override
    public void editerNotes() {
         String jpql = "UPDATE note n SET n.reponse = 1 WHERE n.reponse = 0";
    TypedQuery<Void> query = (TypedQuery<Void>) entityManager.createQuery(jpql);
   
    query.executeUpdate(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

 
}
