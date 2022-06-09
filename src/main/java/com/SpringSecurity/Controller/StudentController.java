package com.SpringSecurity.Controller;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringSecurity.Model.ResponseModel;
import com.SpringSecurity.Model.StudentLoginModel;
import com.SpringSecurity.Model.StudentRegistrationModel;
import com.SpringSecurity.Repository.StudentRepository;
import com.SpringSecurity.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController
{
	@Autowired
	StudentService studentService;
	@Autowired
	ModelMapper mapper;
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseModel> registerStudent(@Valid @RequestBody StudentRegistrationModel model)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(studentService.registerStudent(model));
		responseModel.setMessage("successful");
		responseModel.setStatusCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<ResponseModel> loginStudent(@Valid @RequestBody StudentLoginModel model)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(studentService.loginStudent(model));
		responseModel.setMessage("Success");
		responseModel.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<ResponseModel> getAllStudents()
	{
		ResponseModel model = ResponseModel.getInstance();
		model.setData(studentRepository.findAll());
		model.setMessage("successfull");
		model.setStatusCode(HttpStatus.OK.value());
	
		return new ResponseEntity<ResponseModel>(model,HttpStatus.OK);
	}
	
}
