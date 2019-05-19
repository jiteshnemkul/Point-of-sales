package com.jitesh.repository;

import com.jitesh.bean.Category;
import com.jitesh.bean.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    public ObservableList<Category> CATEGORYLIST = FXCollections.observableArrayList();

}
