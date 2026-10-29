package com.fullstackjava.sql_database.db_locking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstackjava.sql_database.db_locking.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
