package com.example.library.service;

import com.example.library.entity.Category;
import com.example.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long Id){
        Category category;
        category=categoryRepository.findById(Id).orElseThrow(RuntimeException::new);
        return  category;
    }

    public  void createCategory(Category category)
    {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category)
    {
        categoryRepository.save(category);
    }
    public void deleteCategory(Long Id)
    {
        categoryRepository.deleteById(Id);

    }
}
