package com.zaggle1.demozaggle;

import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 

@Entity
@Table(name="employee1")
@NamedQuery(name="getallemployees",query="select e from Employee e")
public class Employee {
    @javax.persistence.Id
    @GeneratedValue

 

    private int id;
    
    private String name;
    private String email;
    private Integer age;
    
    @OneToMany(targetEntity=Skills.class)
    private List<Skills> skills;
    
    
    public List<Skills> getSkills() {
        return skills;
    }

 

    public void setSkills(List<Skills> s) {
        this.skills = s;
    }
    @OneToOne
    private Department department;
    
    public Department getDepartment() {
        return department;
    }

 

    public void setDepartment(Department department) {
        this.department = department;
    }

 

    public Employee() {
        
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
    
}
