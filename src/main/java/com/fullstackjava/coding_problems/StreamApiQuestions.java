package com.fullstackjava.coding_problems;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
// (Shift + Option + F) //code alignment
/**/
public class StreamApiQuestions {

    
   public static void main(String[] args) {
      find_1_from_list();
   }

/*Reverse a string without using predefined methods. */
/*START */
void reverseString(){
   var oldStr="Dheerendra";
   var newStr = "";
   var old = "New";
}
//New Demo
//Updated Demo
//3rd day
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
