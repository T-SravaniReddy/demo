package com.zaggle1.demozaggle;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//public interface Emprepository<Id> extends CrudRepository<Employee,Id>{

 

public interface Emprepository<Id> extends JpaRepository<Employee,Id> {
 Employee findByNameAndEmail(String Name,String Email);
 
 @Query("SELECT e FROM Employee e WHERE e.name = :name and e.age = :age") 
 Employee findByName(@Param("name") String name, @Param("age") int age);
}