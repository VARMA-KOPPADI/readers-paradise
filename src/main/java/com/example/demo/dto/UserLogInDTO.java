package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogInDTO {
	@NotBlank(message = "email cannot blank")
	@Schema(description = "email",example = "enter the email")
	@Column(name = "email")
	private String email;
	@NotBlank(message = "email cannot blank")
	@Schema(description = "email",example = "enter the email")
	@Column(name = "email")
	private String password;

}
