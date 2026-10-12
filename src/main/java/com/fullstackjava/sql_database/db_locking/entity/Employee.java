package com.fullstackjava.sql_database.db_locking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Setter 
@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Employee {
   
    @Id 
    private long id;

    private String name;

    private String department;

    @Version 
    private Long version;

}
