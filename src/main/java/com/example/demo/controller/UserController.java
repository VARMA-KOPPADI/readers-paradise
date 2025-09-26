package com.example.demo.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.model.Constants;
import com.example.demo.model.ResponseMessage;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}

	@PostMapping("/postuser")
	public ResponseEntity<ResponseMessage> inserUser(UserDTO userDTO) {
		try {
			if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty() && userDTO.getPassword().isEmpty()
					|| userDTO.getPassword() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(
						HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAIL, "EMAIL and PASSWORD Feilds Are Mandatory"));
			}
			User insertUserDtls = userService.insertUserDtls(userDTO);
			if (insertUserDtls != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(
						HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "User Data Saved", insertUserDtls));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "User Not Found"));
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseMessage(HttpURLConnection.HTTP_NOT_FOUND, Constants.FAIL, "Internal Server Error"));
		}
	}

}
