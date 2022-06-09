package com.SpringSecurity.Service;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.SpringSecurity.Entity.Student;
import com.SpringSecurity.ExceptionHandling.CustomizedException;
import com.SpringSecurity.Model.StudentLoginModel;
import com.SpringSecurity.Model.StudentRegistrationModel;
import com.SpringSecurity.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	AuthenticationManager authenticationManager;

//	@Override
//	public Student findByemail(String email)
//	{
//		Student student =null; 
//		student =studentRepository.findByEmail(email);
//		if(student != null)
//		{
//			return student;
//		}
//		else
//		{
//			throw new CustomizedException("email not available.");
//		}
//	}

	@Override
	public Student registerStudent(StudentRegistrationModel model)
	{
		Student checkStudent = null;
		checkStudent = studentRepository.findByEmail(model.getEmail());
		if(checkStudent==null)
		{
			Student student = new Student();
			student.setFirstName(model.getFirstName());
			student.setLastName(model.getLastName());
			student.setEmail(model.getEmail());
			student.setUserName(model.getUserName());
			student.setPassword(encoder.encode(model.getPassword()));
		
			studentRepository.save(student);
			return student;
		}
		else
			throw new CustomizedException("student with same email "+model.getEmail()+" already present");
		
	}

	@Override
	public String loginStudent(StudentLoginModel model)
	{
		Authentication authenticationObject = null;
		authenticationObject= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(model.getUserName(),model.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticationObject);
		if(authenticationObject!=null)
			return "login successfull";
		else
			throw new CustomizedException("somethinng went wrong iwth the login");
	}


	
	

}
