package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by anu on 6/25/2017.
 */
@Controller
@RequestMapping("category")
public class CategoryController {
   @Autowired
   private CategoryDao categoryDao;

   @RequestMapping(value= "")
   public String Index (Model model) {
       model.addAttribute("categories",categoryDao.findAll());
       model.addAttribute("title", "Category");
       return "category/index";
   }
    @RequestMapping(value="add",method= RequestMethod.GET)
     public String categoryAddForm (Model model){
       model.addAttribute("title", "Add Category");
       model.addAttribute(new Category());

       return "category/add";
    }
    @RequestMapping(value="add",method= RequestMethod.POST)
    public String categoryProcessAddForm(@ModelAttribute @Valid Category category, Errors errors, Model model ){

         if(errors.hasErrors()){
             model.addAttribute("title", "Add Category");
             return "category/add";

         }
         categoryDao.save(category);
         return "redirect:";

    }
}
