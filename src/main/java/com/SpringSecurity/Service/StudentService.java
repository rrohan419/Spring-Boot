package com.SpringSecurity.Service;

import com.SpringSecurity.Entity.Student;
import com.SpringSecurity.Model.StudentLoginModel;
import com.SpringSecurity.Model.StudentRegistrationModel;

public interface StudentService
{
//	Student findByemail(String email);
	
	Student registerStudent(StudentRegistrationModel model);
	
	String loginStudent(StudentLoginModel model);
}
