package com.blog.mouctar.demoMvc.controller;


import com.blog.mouctar.demoMvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private Connection connection;

    public void getConnection() {
        try {
            //étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String hostName = "localhost";

            String schemaName = "monblog";

            String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + schemaName;

            String user = "root";
            String password = "root";

            //étape 2: créer l'objet de connexion
            connection = DriverManager.getConnection(connectionUrl, user, password);

            System.out.println("La connexion est etablie félicitation !");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Probleme connexion");
        }

    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("La connexion est fermée !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Probleme de fermeture de connexion");
        }
    }

    @GetMapping({"/listAllUsers", "/", ""})
    public String ListeAllUsers(Model model) {
        try {
            Statement statement = connection.createStatement();
            String requestSelect = "SELECT * FROM user";
            ResultSet resultat = statement.executeQuery(requestSelect);
            List<User> users = new ArrayList<>();

            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String nom = resultat.getString(2);
                String prenom = resultat.getString(3);
                String email = resultat.getString(4);
                String password = resultat.getString(4);


                User user = new User(id, nom, prenom, email, password);
                users.add(user);
            }
            System.out.println("Voici les résultats de la requête");
            for (User utilisateurs : users) {
                System.out.println(utilisateurs);
            }
            model.addAttribute("utilisateurs", users);
            model.addAttribute("utilisateur");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return "users";
    }
}
