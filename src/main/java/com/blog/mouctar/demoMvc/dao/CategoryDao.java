package com.blog.mouctar.demoMvc.dao;

import com.blog.mouctar.demoMvc.entity.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

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


    public List<Category>getAllCategory(){
        getConnection();
        List<Category> categories = new ArrayList<>();

        try {


            Statement statement = connection.createStatement();
            String requestSelect = "SELECT * FROM category";
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String name = resultat.getString(2);


                Category category = new Category(id, name);
                categories.add(category);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }

        return categories;
    }

    public Category isertCategory(Category uneCategory){
        String requestInsert = "INSERT INTO category(name) VALUES(?)";

        try {
            getConnection();
            PreparedStatement preparedStatementInsertion = connection.prepareStatement(requestInsert);
            preparedStatementInsertion.setString(2, uneCategory.getName());


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'isertion des données !");
        }
        return uneCategory;

    }

}

