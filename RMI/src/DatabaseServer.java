/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DatabaseServer {
    public static void main(String[] args) {
        try {
            // Création de l'instance du service
            DatabaseService databaseService = new DatabaseServiceImpl();

            // Création du registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrement du service dans le registre RMI
            registry.rebind("DatabaseService", databaseService);

            System.out.println("Serveur RMI démarré.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

