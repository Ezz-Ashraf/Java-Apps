/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kadane;

/**
 *
 * @author Ezzeldin
 */
public class Kadane {

 public static void main (String[] args)
    {
        //The array we will test
        int [] a = {-2,-1,-3,-4,-1,-2,1,0,6};
        //The output
        System.out.println("Maximum contiguous sum is " +
                                       maxSubArraySum(a));
    }
  
    static int maxSubArraySum(int a[])
    {
        //Know the size of array to define the number of loop iterations
        int size = a.length;
        //consider the prev max as the result we will return and current max is the variable which we compare prev max with 
        int Prev_Max = Integer.MIN_VALUE, Cur_Max = 0;
  
        for (int i = 0; i < size; i++)
        {
            //summition of subarray
            Cur_Max = Cur_Max + a[i];
            // if the maximum is increasing so prev max is equal to it
            if (Prev_Max < Cur_Max)
                Prev_Max = Cur_Max;
            // if the summition is negative then we cancel this summition process and start a new subarray
            if (Cur_Max < 0)
                Cur_Max = 0;
        }
        return Prev_Max;
    }
}
