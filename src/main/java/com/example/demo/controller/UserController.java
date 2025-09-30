package com.example.demo.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserLogInDTO;
import com.example.demo.entity.User;
import com.example.demo.model.Constants;
import com.example.demo.model.ResponseMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "UserRegisterController is hear", description = "UserRegister Regsiter and Login")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}

	@Operation(summary = "Create User Register", description = "e commerece online books store  register the users")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "user register successfully"),
			@ApiResponse(responseCode = "400", description = "user register failure"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping("/userregisters")
	public ResponseEntity<ResponseMessage> inserUser(UserDTO userDTO) {
		try {
			if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty() || userDTO.getPassword().isEmpty()
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

	@Operation(summary = "Login functionality", description = "e commerece online books store  login  user")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "User LogIn Successfully"),
			@ApiResponse(responseCode = "400", description = "user login failure"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping("/userLogIn")
	public ResponseEntity<ResponseMessage> loginUser(@RequestBody UserLogInDTO logindto ) {
		
	    try {
	        // Check if email or password is empty
	        if (logindto .getEmail() == null || logindto .getEmail().isEmpty()
	                || logindto .getPassword() == null || logindto .getPassword().isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)//400
	                    .body(new ResponseMessage(Constants.FAILED, "Email and password cannot be empty"));
	        }

	        // Check user credentials
	        User checkUser = userService.checkUser(logindto );
	        
	        if (checkUser == null) {
	        	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                    .body(new ResponseMessage(Constants.FAILED, "Invalid credentials"));
	        } else {
	        	
	        	 return ResponseEntity.status(HttpStatus.ACCEPTED) // 202 
		                    .body(new ResponseMessage(Constants.SUCCESS, "Login successful", checkUser));
	          
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)//500
	                .body(new ResponseMessage(Constants.FAILED, "We are facing server issues"));
	    }
	}


}
