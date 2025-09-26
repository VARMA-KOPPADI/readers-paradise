package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private int id;
	private String userFirstName;
	private String userLastName;
	private String email;
	private String password; 
	private String department;
	private long phNum;

}
