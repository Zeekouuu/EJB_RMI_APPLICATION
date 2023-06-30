/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */

import GO.ZA.NewSessionBeanLocal;
import java.util.Properties;
    import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import GO.ZA.user;

public class Acceuil3Controller {
     public static NewSessionBeanLocal getProxy() throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        props.put("wildfly.naming.client.ejb.context", true);
        InitialContext ctx = new InitialContext(props);
        NewSessionBeanLocal NW = (NewSessionBeanLocal) ctx.lookup("ejb:/YESTA/NewSessionBean!GO.ZA.NewSessionBeanLocal");
        return NW;
    }
      private Long id;


    @FXML
    private Label cne;

    @FXML
    private Label dateNaissance;

    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    public void setId(Long id) throws NamingException {
        NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
       this.id = id;
     user u=  bk.selectuserByID(id);
       // System.out.println("le dexieme id est "+id);
       prenom.setText(" "+u.getPrenom());  
       nom.setText(" "+u.getNom());
       cne.setText(" "+u.getCne());
       dateNaissance.setText(" "+u.getDateNaissance());

       //  System.out.println("Salut : " + u.getPrenom());
    }
}

    



