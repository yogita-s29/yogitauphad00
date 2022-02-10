package com.ttl.springboot1.SpringBootFullStackApplication1.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ttl.springboot1.SpringBootFullStackApplication1.model.Student;
import com.ttl.springboot1.SpringBootFullStackApplication1.repository.StudentRepository;
import com.ttl.springboot1.SpringBootFullStackApplication1.service.MyService;
import com.ttl.springboot1.SpringBootFullStackApplication1.model.Student;
 
@RestController
@CrossOrigin(origins= "http://localhost:4200",allowedHeaders = {"GET","POST","PUT","DELETE"})
@RequestMapping("/api/v1")
public class StudentController {



@Autowired
MyService service;

@Bean
public WebMvcConfigurer corsConfigurer() {
return new WebMvcConfigurerAdapter() {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**").allowedOrigins("*");
}
};
}

@RequestMapping(value = "/student/all", method = RequestMethod.GET)
public List<Student> getStudent() {
System.out.println(this.getClass().getSimpleName() + " getStudents() method invoked");



return service.getStudents();
}

@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
public Student getStudentById(@PathVariable int id) throws Exception {
System.out.println(this.getClass().getSimpleName() + " geStudentById() method invoked");
Optional<Student> emp = service.getStudentById(id);



if (!emp.isPresent())
throw new Exception("could not find Student with id " + id);



return emp.get();
}



@RequestMapping(value = "/student/add", method = RequestMethod.POST)
public Student createStudent(@RequestBody Student emp) {
System.out.println(this.getClass().getSimpleName() + " createStudent method invoked");
return service.addNewStudent(emp);
}



@RequestMapping(value = "/student/update/{id}", method = RequestMethod.PUT)
public Student updateEmployee(@PathVariable int id, @RequestBody Student UpEmp) throws Exception {
System.out.println(this.getClass().getSimpleName() + " createStudent method invoked");



Optional<Student> emp = service.getStudentById(id);



if (!emp.isPresent())
throw new Exception("could not find Student with id " + id);



if (UpEmp.getName() == null || UpEmp.getName().isEmpty())
UpEmp.setName(emp.get().getName());
if (UpEmp.getDepartment() == null || UpEmp.getDepartment().isEmpty())
UpEmp.setDepartment(emp.get().getDepartment());

// for where clause
UpEmp.setId(id);



return service.updateStudent(UpEmp);



}



@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE)
public void deleteStudentById(@PathVariable int empid) throws Exception {
System.out.println(this.getClass().getSimpleName() + " deleteStudentById() method invoked");
Optional<Student> emp = service.getStudentById(empid);



if (!emp.isPresent())
throw new Exception("could not find Student with id " + empid);



service.deleteStudentById(empid);

}
}