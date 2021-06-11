/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divide_sub;

/**
 *
 * @author Ezzeldin
 */
public class Divide_Sub {
    
    
    // Main function
        public static void main(String[] args)
    {
        int arr[] = { 2, 3, 4, 5, 7 };
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);
 
        System.out.println("Maximum contiguous sum is "
                           + max_sum);
    }
        
 // Find the maximum possible sum in arr[]
 // such that arr[m] is part of it
    static int maxCrossingSum(int arr[], int l, int m,
                              int h)
    {
        // Compare elements of left subarray
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }
 
        // Compare elements of right subarray
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }
 
        /* Return sum of elements on left
         and right of mid
         returning only left_sum + right_sum will fail for */
        return Math.max(left_sum + right_sum,
                        Math.max(left_sum, right_sum));
    }
 
    // Returns sum of maxium sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int l, int h)
    {
        // Base Case: Only one element
        if (l == h)
            return arr[l];
 
        // Find middle point
        int m = (l + h) / 2;
 
        /* Return maximum of following three
        possible cases:
        a) Maximum subarray sum in left half
        b) Maximum subarray sum in right half
        c) Maximum subarray sum such that the
        subarray crosses the midpoint */
        return Math.max(
            Math.max(maxSubArraySum(arr, l, m),
                     maxSubArraySum(arr, m + 1, h)),
            maxCrossingSum(arr, l, m, h));
    }
 
}

