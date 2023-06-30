/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zeekouu
 */
public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService{
    private Connection connection;

    public DatabaseServiceImpl() throws RemoteException {
        super();
        // Initialisation de la connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/testar";
        String username = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de la connexion à la base de données.");
        }
    }

  @Override
    public List<String> getAllData() throws RemoteException {
        List<String> data = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                String value = resultSet.getString("prenom");
                data.add(value);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de la récupération des données depuis la base de données.");
        }

        return data;
    }
    
    @Override
    public boolean enregistrerUser(user user) {
        System.out.println(user.getNom());       
        System.out.println(user.getPrenom());
        System.out.println(user.getCne());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());


   // Connection connection = null;
    PreparedStatement statement = null;

    try {
        // Établir la connexion à la base de données
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testar", "root", "");

        // Préparer la requête SQL pour l'insertion
        String query = "INSERT INTO user (nom, prenom, cne, password,dateNaissance,role) VALUES (?, ?, ?, ?,?,?)";
        statement = connection.prepareStatement(query);

        // Définir les valeurs des paramètres de la requête
        statement.setString(1, user.getNom());
        statement.setString(2, user.getPrenom());
        statement.setString(3, user.getCne());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getDateNaissance());
        statement.setString(6, user.getRole());


        

        // Exécuter la requête d'insertion
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérer les exceptions liées à la base de données
    } finally {
        // Fermer les ressources
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }return true;
}
  


    @Override
    public List<user> consulterEtudiant() {
           List<user> data = new ArrayList<>();

    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM testar.user WHERE role='etudiant'");

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String cne = resultSet.getString("cne");
            String password = resultSet.getString("password");
            String dateNaissance = resultSet.getString("dateNaissance");
            String role = resultSet.getString("role");



            user user = new user(nom, prenom, cne, password,dateNaissance,role);
            data.add(user);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
      
    }

    return data; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
public void editerNotes() {
    try {
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("UPDATE note SET reponse = '1' WHERE reponse = '0'");

        System.out.println("Nombre de lignes affectées : " + rowsAffected);

        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
    public List<note> consulterNote() throws RemoteException {
              List<note> data = new ArrayList<>();

    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM note WHERE reponse='0'");

        while (resultSet.next()) {
            
            String etudiant = resultSet.getString("etudiant");
            String module = resultSet.getString("module");
            String valeur = resultSet.getString("valeur");
            double vt = Double.valueOf(valeur);
          note nt = new note(etudiant,module,vt);
            data.add(nt);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
      
    }

    return data; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
}

