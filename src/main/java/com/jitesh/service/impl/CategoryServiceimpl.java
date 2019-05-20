package com.jitesh.service.impl;

import com.jitesh.bean.Category;
import com.jitesh.bean.User;
import com.jitesh.repository.CategoryRepository;
import com.jitesh.repository.UserRepository;
import com.jitesh.service.categoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@ComponentScan
@Service
public class CategoryServiceimpl implements categoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category entity) {

        return categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category find(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

   /* @Override
    public boolean authenticate(String username, String password){
        Category user = this.findByUserName(username);
        if(user == null){
            return false;
        }else{
            if(password.equals(user.getPassword())) return true;
            else return false;
        }
    }*/


    public ObservableList<Category> CATEGORYLIST = FXCollections.observableArrayList();

    public ObservableList<Category> getCategories() {

        ObservableList<Category> list = FXCollections.observableArrayList();

        List<Category> list1=findAll();
        list.addAll(list1);

        return list;
    }


    @Override
    public void deleteInBatch(List<Category> categories) {
        categoryRepository.deleteInBatch(categories);
    }

}
