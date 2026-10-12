package com.fullstackjava.sql_database.db_locking.service;

import org.springframework.stereotype.Service;

import com.fullstackjava.sql_database.db_locking.entity.Employee;
import com.fullstackjava.sql_database.db_locking.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
