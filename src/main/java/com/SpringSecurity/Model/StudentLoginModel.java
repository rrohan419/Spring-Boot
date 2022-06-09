package com.SpringSecurity.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class StudentLoginModel
{
	@NotBlank
	private String userName;
	@NotBlank
//	@Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$\"\r\n")
	private String password;
	
	
	
	public StudentLoginModel()
	{
		super();
	}
	public StudentLoginModel(@NotBlank String userName, @NotBlank String password)
	{
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	
	
}
