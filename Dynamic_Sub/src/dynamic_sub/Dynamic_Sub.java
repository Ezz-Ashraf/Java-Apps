/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_sub;

/**
 *
 * @author Ezzeldin
 */
public class Dynamic_Sub {

      //Main function
     public static void main(String[] args)
    {
         //The array we will test
   int a[] = {-2, -3, 6, -1, -2, 1, 5, -3};
    int n = a.length;   
    int max_sum = maxSubArraySum(a, n);
    //Output
    System.out.println("Maximum contiguous sum is " 
                       + max_sum);
    }
     
     static int maxSubArraySum(int a[], int size)
    {
         //consider the prev max as the result we will return and current max is the variable which we compare prev max with 
        //start comparing with the first element in the array
    int Cur_Max = a[0];
    int Prev_Max = a[0];
  
    for (int i = 1; i < size; i++)
    {
        //we want to know if the summition is increassing or not
           Prev_Max = Math.max(a[i], Prev_Max+a[i]);
    //Take Decision to change the value of the largest sum or not
        Cur_Max = Math.max(Cur_Max, Prev_Max);
    }
    return Cur_Max;
    }
  
      
  
}
