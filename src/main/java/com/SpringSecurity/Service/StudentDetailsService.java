package com.SpringSecurity.Service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.SpringSecurity.Entity.Student;
import com.SpringSecurity.Repository.StudentRepository;

@Service
public class StudentDetailsService implements UserDetailsService
{
	@Autowired
	StudentRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Student student = null;
		student = repository.findByUserName(username);
		if(student!=null)
		{
			return StudentDetailsImpl.build(student);
		}
		else
			throw new UsernameNotFoundException("user not found with username "+username);
		
//		return StudentDetailsImpl.build(repository.findByUserName(username));
				
	}

}
