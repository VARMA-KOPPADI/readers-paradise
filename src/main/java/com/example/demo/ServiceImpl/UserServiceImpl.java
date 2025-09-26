package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public User insertUserDtls(UserDTO userDTO) {

		User user = new User();
		try {
			user.setUserFirstName(userDTO.getUserFirstName());
			user.setUserLastName(userDTO.getUserLastName());
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setDepartment(userDTO.getDepartment());
			user.setPhNum(userDTO.getPhNum());

		} catch (Exception e) {
			e.printStackTrace();
		}
		userRepo.save(user);

		return user;
	}

}
