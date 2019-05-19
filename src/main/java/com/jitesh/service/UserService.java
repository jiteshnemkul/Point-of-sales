package com.jitesh.service;

import com.jitesh.bean.Category;
import com.jitesh.bean.User;
import com.jitesh.generic.GenericService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface UserService extends GenericService<User> {

	boolean authenticate(String email, String password);
	
	User findByUserName(String email);


}
