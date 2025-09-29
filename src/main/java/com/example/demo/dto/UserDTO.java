package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private int id;
	private String userFirstName;
	private String userLastName;
	@NotBlank(message = "email cannot blank")
	@Schema(description = "email",example = "enter the email")
	@Column(name = "email")
	private String email;
	@NotBlank(message = "password cannot blank")
	@Schema(description = "password",example = "enter the password")
	@Column(name = "password")
	private String password; 
	private String department;
	private long phNum;

}
