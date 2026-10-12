package com.fullstackjava.sql_database.db_locking.service;

import org.springframework.stereotype.Service;

import com.fullstackjava.sql_database.db_locking.entity.Employee;
import com.fullstackjava.sql_database.db_locking.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Service class responsible for managing employee operations.
 *
 * Demonstrates optimistic locking using JPA's @Version annotation
 * to detect concurrent updates and prevent stale data from
 * overwriting newer changes.
 *
 * Includes employee department update operations.
 */

@Service 
@AllArgsConstructor 
@NoArgsConstructor 
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private void updateEmployeeRecords(Long id, String department){
        Employee employee = employeeRepository.findById(id).orElseThrow(
                 ()->new RuntimeException("Employee not found"));
                 
                 employee.setDepartment(department);

                 employeeRepository.save(employee);
    }

}
