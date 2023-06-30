/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class DatabaseClient {
    public static void main(String[] args) {
        try {
            // Recherche du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération du service à partir du registre RMI
            DatabaseService databaseService = (DatabaseService) registry.lookup("DatabaseService");

            // Appel des méthodes du service RMI
            List<user> data = databaseService.consulterEtudiant();

            // Utilisation des données récupérées
            for (user value : data) {
                System.out.println(value.getNom());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

