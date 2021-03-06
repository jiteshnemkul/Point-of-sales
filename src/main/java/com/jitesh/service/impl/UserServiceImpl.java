package com.jitesh.service.impl;

import java.util.List;

import com.jitesh.bean.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.jitesh.bean.User;
import com.jitesh.repository.UserRepository;
import com.jitesh.service.UserService;
@ComponentScan
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User entity) {

		return userRepository.save(entity);
	}

	@Override
	public User update(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User find(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean authenticate(String username, String password){
		User user = this.findByUserName(username);
		if(user == null){
			return false;
		}else{
			if(password.equals(user.getPassword())) return true;
			else return false;
		}
	}

	@Override
	public User findByUserName(String email) {
		return userRepository.findByUserName(email);
	}

	@Override
	public void deleteInBatch(List<User> users) {
		userRepository.deleteInBatch(users);
	}

	public ObservableList<User> getemployees() {

		ObservableList<User> list = FXCollections.observableArrayList();

		List<User> list1=findAll();
		list.addAll(list1);

		return list;
	}

	public User addUser(User userInfo) {

		return userRepository.save(userInfo);
	}
}
