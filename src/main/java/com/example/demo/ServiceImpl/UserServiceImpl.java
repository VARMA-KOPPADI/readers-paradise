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
	public User insertUserDtls(UserDTO udto) {

		try {
		@SuppressWarnings("static-access")
		User user = new User()
				.builder()
				.userFirstName(udto.getUserFirstName())
				.userLastName(udto.getUserLastName())
				.email(udto.getEmail())
				.password(udto.getPassword())
				.department(udto.getDepartment())
				.phNum(udto.getPhNum())
				.build();
		userRepo.save(user);
		return user;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public User checkUser(UserDTO userDto) {
		User user = userRepo.findByEmail(userDto.getEmail());
		if(user.getEmail().equals(userDto.getEmail()) && user.getPassword().equals(userDto.getPassword()))
			return user;
		return null;
	}

	
}
