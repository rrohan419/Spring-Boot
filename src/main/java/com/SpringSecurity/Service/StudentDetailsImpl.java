package com.SpringSecurity.Service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.SpringSecurity.Entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentDetailsImpl implements UserDetails
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String userName;
	@JsonIgnore
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	
	

	
	
	public StudentDetailsImpl(Long id, String userName, String password, String firstName, String lastName, String email)
	{
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public static StudentDetailsImpl build(Student student)
	{
		return new StudentDetailsImpl(
				student.getId(),				
				student.getUserName(),
				student.getPassword(),
				student.getFirstName(),
				student.getLastName(),
				student.getEmail());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return null;
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername()
	{
		return userName;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
