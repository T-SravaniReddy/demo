package com.zaggle1.demozaggle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

 

@Entity
@NamedQuery(name="getskills",query="select s from Skills s")
public class Skills {
    @javax.persistence.Id
    @GeneratedValue

 

    private int Id;
    
    private String Name;
    
    public Skills() {
        
    }
    
    public int getId() {
        return Id;
    }

 

    public void setId(int id) {
        Id = id;
    }

 

    public String getName() {
        return Name;
    }

 

    public void setName(String name) {
        Name = name;
    }
    

 

    
}