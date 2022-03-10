package com.blog.mouctar.demoMvc.controller;

import com.blog.mouctar.demoMvc.dao.CommentDao;
import com.blog.mouctar.demoMvc.dao.UserDao;
import com.blog.mouctar.demoMvc.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController extends HttpServlet {

    private UserDao userDao;
    private CommentDao commentDao;

    public UserController() {
        this.userDao = new UserDao();
        this.commentDao = new CommentDao();
    }

    @GetMapping({"/allUsers"})
    public String listeUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("utilisateurs", users);
        return "users";
    }

    /**
     * Ceci est le point d'entree de mon formulaire
     * J'affiche le formulaire
     *
     * @param leModel
     * @return
     */
    @RequestMapping("/afficheForm")
    public String afficheForm(Model leModel) {
        leModel.addAttribute("utilisateur", new User());
        return "utilisateur-form";
    }

    /**
     * Ici je récupère les données du formulaire
     * J'affiche la jsp de confirmation
     * @param unUtilisateur
     * @param model
     * @return
     */
    @RequestMapping("/processForm")
    public String processForm(
            @ModelAttribute("utilisateur") User unUtilisateur, Model model) {
        System.out.println("Utilisateur récupérer" + unUtilisateur);
        userDao.insertUser(unUtilisateur);

        try {

            String message = null;
            if (unUtilisateur != null) {
                message = "l'utilisateur a bien été ajouter en base de données félicitation";
            } else {
                message = "L'utilisateur n'a pas été insérer";
            }
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "utilisateur-confirmation";
    }

    @GetMapping("/afficheUtilisateur" )
    public String getUserById(HttpServletRequest request, Model model){
        Long userId = Long.valueOf(request.getParameter("userid"));
        User user  = userDao.getUserByIdAndCommentAndPost(userId);
        model.addAttribute("utilisateur", user);
        return "singleUser";
    }

    /**
     * Ceci est le point d'entree de mon formulaire pour modifier un utilisateur
     * J'affiche le formulaire
     *
     * @param leModel
     * @return
     */
    @RequestMapping("/afficheFormUpdated")
    public String afficheFormUpdateUser(HttpServletRequest request, Model leModel ) {
        Long userId = Long.valueOf(request.getParameter("userid"));
        User user = userDao.getUserById(userId);
        leModel.addAttribute("utilisateurModifie", user);
        return "updateUtilisateur-form";
    }

    /**
     * Cette methode s'occupe du tritement du formulaire de modification de l'utilisateur
     * @param request
     * @param unUtilisateur
     * @param model
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/updateForm", method = RequestMethod.POST)
    public String updatedUser(HttpServletRequest request, @ModelAttribute("updatedUser") User unUtilisateur, Model model) throws SQLException {
        userDao.updateUser(unUtilisateur);
        return "users";

    }

    @GetMapping("/delete" )
    public String deleteUserById(HttpServletRequest request, Model model){
        Long userId = Long.valueOf(request.getParameter("userid"));
        userDao.deleteUser(userId);
        List<User> users = userDao.getAllUsers();
        model.addAttribute("utilisateurs", users);
        return "users";

    }


}