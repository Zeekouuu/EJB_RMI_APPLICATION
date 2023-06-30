
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
public class note implements Serializable{
     private static final long serialVersionUID = 7530713031723732449L;
    private String etudiant;
    private String module ;
    private String reponse;
    private double valeur ;
    public note(){
        
    }

    public note(String etudiant, String module,  double valeur) {
        this.etudiant = etudiant;
        this.module = module;
        
        this.valeur = valeur;
    }
    

    public String getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(String etudiant) {
        this.etudiant = etudiant;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
}
