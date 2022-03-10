package com.blog.mouctar.demoMvc.controller;

import com.blog.mouctar.demoMvc.dao.CategoryDao;
import com.blog.mouctar.demoMvc.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class CategoryController extends HttpServlet {

    private CategoryDao serviceCategory;

    public CategoryController() {
        this.serviceCategory = new CategoryDao();
    }

    @GetMapping({"/allCategory"})
    public String ListeCategory(Model model) {
        List<Category> categories = serviceCategory.getAllCategory();
        model.addAttribute("categories", categories);
        return "categories";
    }

    /**
     * Ceci est le point d'entree de mon formulaire
     * J'affiche le formulaire
     *
     * @param leModel
     * @return
     */
    @RequestMapping("/categoryForm")
    public String afficheFormCategory(Model leModel) {
        leModel.addAttribute("categorie", new Category());
        return "category-form";
    }

    /**
     * Ici je récupère les données du formulaire
     * J'affiche la jsp de confirmation
     *
     * @param uneCategorie
     * @return
     */
    @RequestMapping("/formCategory")
    public String processFormCategory(
            @ModelAttribute("categorie") Category uneCategorie, Model model) {
        System.out.println("Categorie récupérer" + uneCategorie);
        // TODO : save in database unUtilisateur
         serviceCategory.isertCategory(uneCategorie);

        try {

            String message = null;
            if (uneCategorie != null) {
                message = "l'utilisateur a bien été ajouter en base de données félicitation";
            } else {
                message = "L'utilisateur n'a pas été insérer";
            }
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "category-confirmation";
    }


}
