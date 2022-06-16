package com.zaggle1.demozaggle;


import java.awt.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Repository
@Transactional
public class Controller1 {

	@PersistenceContext
     EntityManager em;
	
	@Autowired
    Emprepository emprep;
     
	/*@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Seperate Controller Hello %s!", name);
	}*/
	
	@GetMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Seperate Controller Hi %s!", name);
	}
	@GetMapping("/hello/new")
	public String helloNew(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Seperate Controller New Hello %s!", name);
	}
	
	@RequestMapping(value="/countries/{testval}", method=RequestMethod.GET)
//  public ArrayList getcountries(@PathVariable String testval) {
	public ResponseEntity getCountries(@PathVariable String testval) {
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.add("India");
		countryList.add("USA");
		countryList.add(testval);
		//return countryList;
		return new ResponseEntity<>(countryList,HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/addemp",method=RequestMethod.POST)
//  public ArrayList getcountries(@PathVariable String testval) {
  public ResponseEntity addemployees(@RequestBody Employee emp) {
       
  //Employee e = new Employee(); one way
      //e.setAge(emp.getAge());   
      //e.setName(emp.getName());
      return new ResponseEntity<>(emp,HttpStatus.OK); //other way
  }
	*/
	@RequestMapping(value="/addempskill",method=RequestMethod.POST)
  public ResponseEntity addemployeeskill(@RequestBody EmpSkills empSkill) {
      return new ResponseEntity<>(empSkill,HttpStatus.OK); 
  }
  
	@RequestMapping(value="/addemp",method=RequestMethod.POST)
//  public ArrayList getcountries(@PathVariable String testval) {
  public ResponseEntity addemployees(@RequestBody Employee emp) {
      
      
      Employee emp1 = new Employee();
      emp1.setName(emp.getName());
      emp1.setEmail(emp.getEmail());
      emp1.setAge(emp.getAge());
      
      emp1.setDepartment((em.find(Department.class,133)));
      
      ArrayList sks = (ArrayList) em.createNamedQuery("getskills").getResultList();
      emp1.setSkills(sks);
      em.persist(emp1);
      em.close();
      return new ResponseEntity<>(emp,HttpStatus.OK);
      
  }
  
  @RequestMapping(value="/findemp/{empid}",method=RequestMethod.GET)
  public String findemployees(@PathVariable Integer empid) {
      
      Employee emp1 = new Employee();
      emp1 =em.find(Employee.class, empid);
      // em.persist(emp1);
      em.close();
  
      return emp1.getName();
      
  }
  @RequestMapping(value="/updateemp",method=RequestMethod.POST)
  public ResponseEntity updateemployees(@RequestBody Employee emp) {
      
      Employee emp1 = new Employee();
      emp1 =em.find(Employee.class, emp.getId());
      emp1.setName(emp.getName());
      emp1.setEmail(emp.getEmail());
      emp1.setAge(emp.getAge());
      
      em.merge(emp1);
      em.close();
      return new ResponseEntity<>(emp,HttpStatus.OK);
      
  }
  @RequestMapping(value="/deleteemp/{empid}",method=RequestMethod.DELETE)
  public String deleteemployees(@PathVariable Integer empid) {
      
      Employee emp1 = new Employee();
      emp1 =em.find(Employee.class, empid);
      em.remove(emp1);
      em.close();
      
      return "Successfully deleted";
      
  }
  /*@GetMapping("/hello")
  //public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
  public List hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      TypedQuery<Employee> qry = em.createQuery("select Id,Name from Employee",Employee.class);
      List emplist = (List) qry.getResultList();
     
  //return String.format("Seperate Controller Hello %s!", name);
      return emplist;
  }*/
  @GetMapping("/all")
  public ArrayList all(@RequestParam(value = "name", defaultValue = "World") String name) {
      ArrayList emp = (ArrayList) em.createQuery("select e from Employee e",Employee.class).getResultList();
    //return String.format("Seperate Controller Hello %s!", name);
        return emp;
  }
  @GetMapping("/hello")
  public Employee hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	    //  ArrayList emp = (ArrayList) em.createQuery("select e from Employee e where Name=:name",Employee.class).getResultList();
	        TypedQuery<Employee> qry = em.createQuery("select e from Employee e where e.Id=:idd",Employee.class);
	        qry.setParameter("idd", 1);
	        Employee e = qry.getSingleResult();
	       
	    //return String.format("Seperate Controller Hello %s!", name);
	        return e;
	    }
  @GetMapping("/emplist")
  public ArrayList hello1() {
    ArrayList emp = (ArrayList) em.createNamedQuery("getallemployees").getResultList();
     //placed some query namedquery in employee class 
      
  //return String.format("Seperate Controller Hello %s!", name);
      return emp;
  }
  
  @RequestMapping(value="/adddept",method=RequestMethod.POST)
  public ResponseEntity adddepartment(@RequestBody Department dept) {
  Department dep = new Department();
      dep.setName(dept.getName());
      em.persist(dep);
      em.close();
      return new ResponseEntity<>(dep,HttpStatus.OK); 
  }
  @RequestMapping(value="/addskills",method=RequestMethod.POST)
  public ResponseEntity addskills(@RequestBody Skills skills) {
      Skills  sk= new Skills();
      sk.setName(skills.getName());
      em.persist(sk);
      em.close();
      return new ResponseEntity<>(sk,HttpStatus.OK);
  }
  
  @GetMapping("/empsearch")
  public Employee hello2() {
  //  ArrayList emp = (ArrayList) em.createnamedQuery("getallemployees").getResultList();
    Employee emp =emprep.findByNameAndEmail("amala","amala123@gmail.com");
  //return String.format("Seperate Controller Hello %s!", name);
      return emp;
  }
  @GetMapping("/empsearchname")
  public Employee searchByName() {
  //  ArrayList emp = (ArrayList) em.createnamedQuery("getallemployees").getResultList();
    Employee emp = emprep.findByName("krishna", 34);
  //return String.format("Seperate Controller Hello %s!", name);
      return emp;
  }
  
}
