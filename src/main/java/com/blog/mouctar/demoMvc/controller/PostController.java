package com.blog.mouctar.demoMvc.controller;

import com.blog.mouctar.demoMvc.dto.CommentDto;
import com.blog.mouctar.demoMvc.dao.CommentDao;
import com.blog.mouctar.demoMvc.dao.PostDao;
import com.blog.mouctar.demoMvc.entity.Post;
import com.blog.mouctar.demoMvc.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class PostController extends HttpServlet {

    private PostDao postDao;
    private CommentDao commentDao;
    private UserDao userDao;

    public PostController() {
        this.postDao = new PostDao();
        this.commentDao = new CommentDao();
        this.userDao = new UserDao();
    }

    @GetMapping({"/articles"})
    public String listePost(Model model) {

        List<Post> posts = postDao.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }


    @GetMapping("/single_post" )
    public String getPostById(HttpServletRequest request, Model model){
        Long postId = Long.valueOf(request.getParameter("postid"));
        Post post  = postDao.getPostAndComment(postId);
      List<CommentDto>comments =  commentDao.getCommentAndUser(postId);
        System.out.println("Les commentaires" + comments);
        System.out.println("Le post" + post);
        model.addAttribute("postSingle", post);
        model.addAttribute("commentaires", comments);
        return "singlePost";
    }

    /**
     * Ceci est le point d'entree de mon formulaire
     * J'affiche le formulaire
     *
     * @param leModel
     * @return
     */
    @RequestMapping("/afficheFormPost")
    public String afficheForm(Model leModel) {
        leModel.addAttribute("post", new Post());
        Map<Long, String> users = userDao.getUserIdAndFirstNameLastName();
        leModel.addAttribute("utlisateurs", users);
        return "post-form";
    }

    /**
     * Ici je récupère les données du formulaire
     * J'affiche la jsp de confirmation
     *
     * @param unPost
     * @return
     */
    @RequestMapping("/processFormPost")
    public String processForm(
            @ModelAttribute("post") Post unPost, Model model) {
        System.out.println("Post récupérer" + unPost);
        postDao.insertPost(unPost);



        try {

            String message = null;
            if (unPost != null) {
                message = "le post a bien été ajouter en base de données félicitation";
            } else {
                message = "Le post n'a pas été insérer";
            }
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "post-confirmation";
    }

}