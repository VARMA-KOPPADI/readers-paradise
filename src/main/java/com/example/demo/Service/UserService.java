package com.example.demo.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserLogInDTO;
import com.example.demo.entity.User;

public interface UserService {
	
	public User insertUserDtls(UserDTO userDTO);
	public User checkUser(UserLogInDTO userDto);

}
