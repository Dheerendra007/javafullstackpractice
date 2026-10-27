package com.fullstackjava.coding_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fullstackjava.sql_database.db_locking.entity.Employee;
// (Shift + Option + F) //code alignment
// Duplicate Line Down	Shift + Option + ↓
// remove unused imports and declarations Option + Shift + O and Command + Shift + P
/**/
public class StreamApiQuestions {

   public static void main(String[] args) {
      findEmployeeSecondHighestSalaryStream();
      //findReateWordsAndArangeInOrder();
      //findEmployeeHighestSalaryStream();
      //findSecondHighestNumberInArray();
      //findDuplicateElementArray();
      //filterDuplicateElementList();
     // find_1_from_list();
     // reverseString();
     //Test
   }

   /*Find the employee with the Second highest salary using Streams. */
/*START */
  static void findEmployeeSecondHighestSalaryStream() {

    List<EmployeeData> employees = new ArrayList<>();

    employees.add(new EmployeeData("Rohan", 1000));
    employees.add(new EmployeeData("Rohit", 5000));
    employees.add(new EmployeeData("Rohit", 5000));
    employees.add(new EmployeeData("Snehal", 5000));
    employees.add(new EmployeeData("Ronak", 3000));

    List<EmployeeData> result = employees.stream()
        .map(EmployeeData::employeeSalary)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .map(salary -> employees.stream()
            .filter(e -> e.employeeSalary() == salary)
            .collect(Collectors.toList()))
        .orElse(Collections.emptyList());

    result.forEach(System.out::println);
}

  /*END */
   /*two operations using Java Stream API:
1. Count repeated words and display their frequency.
2. Remove duplicate words and sort all unique words in alphabetical order. 
Input : Hello my name is is Dheer and this is my name
Output : my = 2
name = 2
is = 3
Sorted unique sentence:
and Dheer Hello is my name this*/
/*START */
static void findReateWordsAndArangeInOrder(){

        String input = "Hello my name is is Dheer and this is my name";

        // Step 1: Split sentence into words
        String[] words = input.split("\\s+");

        // Step 2: Count frequency of each word
        Map<String, Long> frequency = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        // Step 3: Print only repeated words
        frequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " = " + entry.getValue()
                        )
                );

        // Step 4: Remove duplicates and sort alphabetically
        String sortedSentence = Arrays.stream(words)
                .distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining(" "));

        System.out.println(sortedSentence);
    
}
              
  /*END */
/*Find the employee with the highest salary using Streams. */
/*START */
  static void findEmployeeHighestSalaryStream(){
   List<EmployeeData> employeeList = new ArrayList<>();
   employeeList.add(new EmployeeData("Rohan",1000));
   employeeList.add(new EmployeeData("Rohit",5000));
   employeeList.add(new EmployeeData("Ronak",3000));
  
   EmployeeData highestSal = employeeList.stream().
   max(Comparator.comparingDouble(EmployeeData::getEmployeeSalary))
   .orElseThrow();
   System.out.println(highestSal.getEmployeeName());
   System.out.println(highestSal.getEmployeeSalary());
}

  /*END */
/*Find the second-highest number in an array.. */
/*START */
  static void findSecondHighestNumberInArray(){
   int []arr = {1,21,12,13,14,15,16};
   int firstHighst = Integer.MIN_VALUE;
   int secondHighest = Integer.MIN_VALUE;

   for (int num : arr) {
      if(num>firstHighst){
         secondHighest = firstHighst;
         firstHighst = num;
      } else if(num>secondHighest && num<firstHighst){
         secondHighest = num;
      }
   }
   System.out.println(secondHighest);
  }
  /*END */
/*Find duplicate elements in an array. */
/*START */
  static void findDuplicateElementArray(){
   int []number = {1,2,2,3,4,4,5,6};
   Set<Integer> seen = new HashSet<>();
   Set<Integer> duplicate = new HashSet<>();
    for (Integer num : number) {
      if(!seen.add(num)){
         duplicate.add(num);
      }
    }
    System.out.println(duplicate);
   }
  /*END */
   /* Using Java 8 Streams, how would you find the duplicate elements and
    print each duplicate only once?*/

    /*How it works
1. numbers.stream() creates a stream from the list.
2. seen.add(n) returns true when an element is added for the first time.
3. !seen.add(n) returns true when the element has already appeared, so it is a duplicate.
4. collect(Collectors.toSet()) ensures each duplicate appears only once in the result.
5. forEach(System.out::println) prints the duplicates. */
/*START */
  static void filterDuplicateElementList(){
   int []number = {1,2,2,3,4,4,5,6};
 List<Integer> numbers =
    Arrays.asList(10, 20, 10, 30, 20, 40);
    Set<Integer> seen = new HashSet<>();
    numbers.stream().filter(n->!seen.add(n))
    .collect(Collectors.toSet()).forEach(System.out::println);
   }
  /*END */
  
/*Reverse a string without using predefined methods. */
/*START */
static void reverseString(){
   var oldStr="abcd";
   char charArray[] = oldStr.toCharArray();
   char charNewArray[] = oldStr.toCharArray();
   int j=0;
   for(int i=oldStr.length()-1;i>=0;i--){
     charNewArray[j] = charArray[i];
     j++;
   }
   System.out.println(charNewArray);
   System.out.println(charNewArray);
}
/*END */

   /*We have a list of integers. Find out all the numbers starting with 1 using 
stream function (11, 18, 20, 24, 85, 66, 13) */
/*START */
 static void find_1_from_list(){

    List<Integer> list = List.of(11, 18, 20, 24, 85, 66, 13);
    List<Integer> result = list.stream().filter(n->n!=null)//Null-safe check
    .map(Object::toString)//Convert Int to string
    .filter(n->n.startsWith("1"))//Filter number that start with 1
    .map(Integer::parseInt)//Convert String back to integer
    .collect(Collectors.toList());//Collect result into list
    System.out.println("\n Numbers starting with 1: " + result+"\n");
 }
 /*END */

}
