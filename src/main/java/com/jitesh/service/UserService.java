package com.jitesh.service;

import com.jitesh.bean.Category;
import com.jitesh.bean.User;
import com.jitesh.generic.GenericService;
import com.jitesh.repository.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService extends GenericService<User> {


	boolean authenticate(String email, String password);
	
	User findByUserName(String email);
	public ObservableList<User> EMPLOYEELIST = FXCollections.observableArrayList();
	public ObservableList<User> getemployees();

	public User addUser(User userInfo);

}
