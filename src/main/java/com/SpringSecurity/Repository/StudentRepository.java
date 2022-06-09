package com.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SpringSecurity.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{
	Student findByEmail(String email);
	Student findByUserName(String userName);
}
