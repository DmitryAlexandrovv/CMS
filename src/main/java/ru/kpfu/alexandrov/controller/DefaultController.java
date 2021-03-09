package ru.kpfu.alexandrov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.alexandrov.dao.ArticleDao;
import ru.kpfu.alexandrov.model.Article;

import java.util.Date;
import java.util.List;

@Controller
public class DefaultController {
    @Autowired
    ArticleDao articleRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(Model model) {
        List<Article> articles = articleRepo.getAll();
        for(int i = 0;i < articles.size();i++){
            if(articles.get(i).getParentId() != 0) {
                
            }
        }
        model.addAttribute("articles", articleRepo.getAll());
        return "index";
    }

    @RequestMapping(value = "/articleGenerator", method = RequestMethod.GET)
    public String articleGenerator(Model model) {
        model.addAttribute("articles", articleRepo.getAll());
        return "articleGenerator";
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String mainPagePost(@ModelAttribute("userFormData") Article model, ModelMap map) {
        System.out.println(model.getParentId());
        Article article = new Article(new Date().getTime(), model.getTitle(), model.getContent(), model.getParentId());
        articleRepo.put(article);
        map.addAttribute("title", article.getTitle());
        map.addAttribute("publicationDate", article.getDate());
        map.addAttribute("content", article.getContent());
        return "article";
    }
}
