package com.blog.mouctar.demoMvc.dao;

import com.blog.mouctar.demoMvc.databaseConfig.DatabaseConfig;
import com.blog.mouctar.demoMvc.entity.Comment;
import com.blog.mouctar.demoMvc.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    private DatabaseConfig databaseConfig;

    public PostDao(){
        databaseConfig = new DatabaseConfig();
    }



    public List<Post> getAllPosts() {
        Connection connection = databaseConfig.getConnection();
        databaseConfig.getConnection();
        List<Post> posts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String requestSelect = "SELECT * FROM post";
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String title = resultat.getString(2);
                String description = resultat.getString(3);
                Date created_at = resultat.getDate(4);


                Post post = new Post(id, title, description, created_at);
                posts.add(post);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }

        return posts;
    }

    public Post postById(Long postId) {
        Connection connection = databaseConfig.getConnection();
        Post post = null;
        try {
            Statement statement = connection.createStatement();
            String requestSelect = "SELECT * FROM post where id =" + postId;
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {
                //Récupérer par nom de colonne
                Long id = resultat.getLong(1);
                String title = resultat.getString(2);
                String description = resultat.getString(3);
                java.util.Date created_at = resultat.getDate(4);

                post = new Post(id, title, description, created_at);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return post;
    }


    public Post getPostAndComment(Long postId) {
        Connection connection = databaseConfig.getConnection();
        Post post = null;
        List<Comment>comments = new ArrayList<>();;

        // Il reste la requete pour récuperer des commentaire
        //Request3: Recuperer les commentaires
        // List<Comment>comments;
        // user.setComments(comments);
        try {

            // Premiere requete: récupérer le user
            // MonUser user;
            Statement statement = connection.createStatement();
            String requestSelect = "SELECT * FROM post where id =" + postId;
            ResultSet resultat = statement.executeQuery(requestSelect);


            //étape 5: extraire les données
            while (resultat.next()) {

                Long id = resultat.getLong(1);
                String title = resultat.getString(2);
                String description = resultat.getString(3);
                Date created_at = resultat.getDate(4);


                post = new Post(id, title, description, created_at);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return post;
    }




    public Post insertPost(Post post){

        String requestInsert = "INSERT INTO post(title, description, created_at, user_Id) VALUES(?,?,?,?)";

        try {
            Connection connection = databaseConfig.getConnection();
            PreparedStatement preparedStatementInsertion = connection.prepareStatement(requestInsert);
            preparedStatementInsertion.setString(1, post.getTitle());
            preparedStatementInsertion.setString(2, post.getDescription());
            preparedStatementInsertion.setDate(3, (Date) post.getCreated_at());
            preparedStatementInsertion.setLong(4 , post.getUserId());
            preparedStatementInsertion.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'isertion des données !");
        }
       return post;

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


