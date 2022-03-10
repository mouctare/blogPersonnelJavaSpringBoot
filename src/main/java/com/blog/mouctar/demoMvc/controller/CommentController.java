package com.blog.mouctar.demoMvc.controller;

import com.blog.mouctar.demoMvc.dao.CommentDao;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {

    private CommentDao serviceComment = null;

    public CommentController() {
        this.serviceComment =  new CommentDao();
    }

   // @GetMapping({"/allCommentTheUuser}"})
  //  public String CommentaireEffectuerParUser(Model model) {
      //  List<Comment> comments = serviceComment.commentByUser();
       // model.addAttribute("commentaire", comments);
   //     return "comments";
  //  }
}
