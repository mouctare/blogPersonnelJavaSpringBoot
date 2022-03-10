package com.blog.mouctar.demoMvc.dao;

import com.blog.mouctar.demoMvc.databaseConfig.DatabaseConfig;
import com.blog.mouctar.demoMvc.dto.CommentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    private DatabaseConfig databaseConfig;

    public CommentDao(){
        databaseConfig = new DatabaseConfig();
    }



    // public List<CommentDto> getCommentAndUser(long postId){
//        Connection connection = databaseConfig.getConnection();
//        databaseConfig.getConnection();
//        List<Post> posts = new ArrayList<>();
//
//        String requestSelectPost =   "SELECT comments.id comments.content, comments.created_at, comments.user_id,  user.first_name, user.last_name " +
//
//                "FROM comments " +
//                "inner join user ON user.id = comments.user_id " +
//                "inner join post ON post.id = comments.post_id " +
//                "where  post_id =" + postId;
//        ResultSet resultatPost = connection.executeQuery(requestSelectPost);
//
//        while (resultatPost.next()) {
//
//            Long idComment = resultatPost.getLong(1);
//            String content = resultatPost.getString(2);
//            java.sql.Date created_at = resultatPost.getDate(3);
//            Integer idUser = resultatPost.getInt(4);
//            String nom = resultatPost.getString(5);
//            String prenom = resultat.getString(6);
//
//
//
//            // Comment comment = new Comment(idComment, content, created_at);
//            CommentDto commentDto = new CommentDto(idComment, content, created_at, idUser, nom, prenom);
//            comments.add(commentDto);
//
//        }
//
//    }

    public List<CommentDto> getCommentAndUser(Long postId) {
        Connection connection = databaseConfig.getConnection();

        List<CommentDto>commentDtos = new ArrayList<>();;

        try {

            Statement statement = connection.createStatement();

            String requestSelectPost =   "SELECT comments.description, comments.created_at, comments.user_id,  user.first_name, user.last_name " +

                    "FROM comments " +
                    "inner join user ON user.id = comments.user_id " +
                    "inner join post ON post.id = comments.post_id " +
                    "where  post_id =" + postId;
            ResultSet resultatPost = statement.executeQuery(requestSelectPost);

            while (resultatPost.next()) {


                String content = resultatPost.getString(1);
                java.sql.Date created_at = resultatPost.getDate(2);
                Integer idUser = resultatPost.getInt(3);
                String nom = resultatPost.getString(4);
                String prenom = resultatPost.getString(5);



                // Comment comment = new Comment(idComment, content, created_at);
                CommentDto commentDto = new CommentDto(content, created_at, idUser, nom, prenom);
                commentDtos.add(commentDto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème sélection");
        }
        return commentDtos;
    }


}


