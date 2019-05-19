package com.jitesh.service;

import com.jitesh.bean.Category;
import com.jitesh.bean.User;
import com.jitesh.generic.GenericService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public interface categoryService extends GenericService<Category> {

    List<Category> findAll();
    public ObservableList<Category> CATEGORYLIST = FXCollections.observableArrayList();
    public ObservableList<Category> getCategories();

}
