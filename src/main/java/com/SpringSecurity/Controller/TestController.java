package com.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
	@GetMapping("/")
	public String Welcome()
	{
		return "<h1>Welcome All</h1>";
	}
	@GetMapping("/users")
	public String users()
	{
		return "<h1>Welcome Users and Admin</h1>";
	}
	@GetMapping("/admins")
	public String admins()
	{
		return "<h1>Welcome Admins</h1>";
	}
}
