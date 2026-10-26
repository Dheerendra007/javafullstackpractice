package com.fullstackjava.coding_problems;

/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Setter 
@Getter 
public class EmployeeData {
  private String employeeName;
  private long employeeSalary;
   @Override
    public String toString() {
        return "EmployeeData{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}*/

public record EmployeeData(
    String employeeName,
    long employeeSalary
) {}
