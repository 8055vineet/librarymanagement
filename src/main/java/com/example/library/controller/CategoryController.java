package com.example.library.controller;

import com.example.library.entity.Category;
import com.example.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
@Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        final List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        categoryService.deleteCategory(id);

        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/update-category/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findCategoryById(id);

        model.addAttribute("category", category);
        return "update-category";
    }
    @PostMapping("/update-category/{id}")
    public String updateCategory(@PathVariable("id") Long id, Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "update-category";
        }

        categoryService.updateCategory(category);
        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/addCategory")
    public String showCreateForm(Category category) {
        return "add-category";
    }

    @PostMapping("/add-category")
    public String createCategory(Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-category";
        }

        categoryService.createCategory(category);
        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categories";
    }




}
