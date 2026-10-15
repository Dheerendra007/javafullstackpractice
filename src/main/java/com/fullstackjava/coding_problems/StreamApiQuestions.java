package com.fullstackjava.coding_problems;

import java.util.List;
/**/
public class StreamApiQuestions {

    
   public static void main(String[] args) {
    
   }

   /*We have a list of integers. Find out all the numbers starting with 1 using 
stream function (11, 18, 20, 24, 85, 66, 13) */
 int find_1_from_list(){

    List<Integer> list = List.of(11, 18, 20, 24, 85, 66, 13);
    list.stream().filter(n->n.start)
    return 0;
    
 }

}
