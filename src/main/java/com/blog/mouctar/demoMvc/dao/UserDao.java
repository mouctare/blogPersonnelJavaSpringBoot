package com.blog.mouctar.demoMvc.dao;

import com.blog.mouctar.demoMvc.databaseConfig.DatabaseConfig;
import com.blog.mouctar.demoMvc.entity.Comment;
import com.blog.mouctar.demoMvc.entity.User;
import com.blog.mouctar.demoMvc.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

    private DatabaseConfig databaseConfig;

    public UserDao(){
        databaseConfig = new DatabaseConfig();
    }



    public List<User> getAllUsers() {
        Connection connection = databaseConfig.getConnection();
        databaseConfig.getConnection();
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String requestSelect = "select * from user";
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String nom = resultat.getString(2);
                String prenom = resultat.getString(3);
                String email = resultat.getString(4);
                String password = resultat.getString(5);

                User user = new User(id, nom, prenom, email, password);
                users.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }

        return users;
    }

    public Map<Long, String> getUserIdAndFirstNameLastName(){
        Connection connection = databaseConfig.getConnection();
        Map<Long, String> users = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            String requestSelect = "SELECT id, first_name, last_name FROM user";
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String nom = resultat.getString(2);
                String prenom = resultat.getString(3);

               users.put(id,  nom + prenom);


            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return users;
    }
    public User getUserById(Long userId) {
        Connection connection = databaseConfig.getConnection();
        User user = null;
        try {
            Statement statement = connection.createStatement();
            String requestSelect = "SELECT * FROM user where id =" + userId;
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String nom = resultat.getString(2);
                String prenom = resultat.getString(3);
                String email = resultat.getString(4);
                String password = resultat.getString(5);

                user = new User(id, nom, prenom, email, password);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return user;
    }


    public User getUserByIdAndCommentAndPost(Long userId) {
        Connection connection = databaseConfig.getConnection();
        User user = null;
        List<Post>posts = new ArrayList<>();
        List<Comment>comments = new ArrayList<>();;

        // Il reste la requete pour récuperer des commentaire
        //Request3: Recuperer les commentaires
        // List<Comment>comments;
        // user.setComments(comments);
        try {

            // Premiere requete: récupérer le user
            // MonUser user;
            Statement statement = connection.createStatement();
            String requestSelect = "select * from user where id =" + userId;
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {

                Long id = resultat.getLong(1);
                String nom = resultat.getString(2);
                String prenom = resultat.getString(3);
                String email = resultat.getString(4);
                String password = resultat.getString(5);

                user = new User(id, nom, prenom, email, password);
            }

            // Requete2 recuperer les posts
            // List<Post>posts;
            String requestSelectPost = "select * from post where user_id =" + userId;
            ResultSet resultatPost = statement.executeQuery(requestSelectPost);

            while (resultatPost.next()) {

                Long idPost = resultatPost.getLong(1);
                String titre_post = resultatPost.getString(2);
                String description_post = resultatPost.getString(3);
                Date date_creation_post = resultatPost.getDate(4);

                Post post = new Post(idPost, titre_post, description_post, date_creation_post);
                posts.add(post);

            }

            user.setPosts(posts);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return user;
    }


    public User insertUser(User unUtilisateur){

        String requestInsert = "INSERT INTO user(first_name, last_name, email, password) VALUES(?,?,?,?)";

        try {
            Connection connection = databaseConfig.getConnection();
            PreparedStatement preparedStatementInsertion = connection.prepareStatement(requestInsert);
            preparedStatementInsertion.setString(1, unUtilisateur.getFirst_name());
            preparedStatementInsertion.setString(2, unUtilisateur.getLast_name());
            preparedStatementInsertion.setString(3, unUtilisateur.getEmail());
            preparedStatementInsertion.setString(4, unUtilisateur.getPassword());
            preparedStatementInsertion.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'isertion des données !");
        }
       return unUtilisateur;

    }

    public User updateUser(User updatedUser) throws SQLException {

        System.out.println("Je passe par updateUser");
        Connection connection = databaseConfig.getConnection();
        String requestUpdate = "UPDATE user SET first_name = ? ,last_name = ? ,email = ? , password = ? where id = ?";

        try {
            databaseConfig.getConnection();
            ;
            PreparedStatement preparedStatementInsertion = connection.prepareStatement(requestUpdate);
            preparedStatementInsertion.setString(1, updatedUser.getFirst_name());
            preparedStatementInsertion.setString(2, updatedUser.getLast_name());
            preparedStatementInsertion.setString(3, updatedUser.getEmail());
            preparedStatementInsertion.setString(4, updatedUser.getPassword());
            preparedStatementInsertion.setLong(5, updatedUser.getId());
            preparedStatementInsertion.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'isertion des données !");
        }
        return updatedUser;
    }

    public void deleteUser(Long userId) {
        Connection connection = databaseConfig.getConnection();

        try {
            Statement statement = connection.createStatement();

            String requestSelect = "DELETE FROM user where id =" + userId;
             statement.executeUpdate(requestSelect);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Probléme lors de la suppression");
        }

      databaseConfig.closeConnection();
    }


}


