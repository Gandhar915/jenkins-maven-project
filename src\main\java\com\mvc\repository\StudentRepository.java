package com.mvc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.entity.Student;

@Repository
public class StudentRepository {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// --
	@Transactional
	public void saveNewStudent(Student student) {
		this.hibernateTemplate.save(student);
	}
	
	public List<Student> getAllStudentData(){
		List<Student> listOfStudents = this.hibernateTemplate.loadAll(Student.class);
		return listOfStudents;
	}
	
	public Student getById(int id){
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	@Transactional
	public void deleteData(Student stduent){
		this.hibernateTemplate.delete(stduent);
	}
	
	@Transactional
	public void updateData(Student student){
		this.hibernateTemplate.update(student);
	}

}
