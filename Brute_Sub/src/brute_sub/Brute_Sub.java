/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brute_sub;

/**
 *
 * @author Ezzeldin
 */
public class Brute_Sub {

    //Brute force way
    public static void main(String[] args) {
       //The array we will test
        int[] a={4,3,5,2,6,-10};
        System.out.println("The max sum =  "+MaxSum(a));
        
    }
    
    static int MaxSum(int []a)
    {
        //Test number between i and j
        int n=a.length;
        int max =Integer.MIN_VALUE;
//    for (int i = 0; i < n; i++)
//    for (int j = i; j < n; j++) {
//        int sum = 0;
//        for (int k = i; k <= j; k++)
//            sum += a[k];
//        if (sum > max)
//            max = sum;
//    }
        for(int i = 0; i < n; i++) {
    int sum = 0;
    for (int j = i; j < n; j++) {
        sum += a[j];
        if (sum > max)
            max = sum;
    }
}
    return max;
    }
}
