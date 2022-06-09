package com.SpringSecurity.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class StudentRegistrationModel
{
	@NotBlank
	private String firstName;
	private String lastName;
	@NotBlank
	private String userName;
	@NotBlank
//	@Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\"", message = "Minimum eight characters, at least one letter and one number")
	private String password;
	@Email
	@NotBlank
	private String email;
		
	public StudentRegistrationModel()
	{
		super();
	}
	public StudentRegistrationModel(@NotBlank String firstName, String lastName, @NotBlank String userName, @NotBlank String password, @Email @NotBlank String email)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	public String getEmail()
	{
		return email;
	}
	
	
	
	
}
