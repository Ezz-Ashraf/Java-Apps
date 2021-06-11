/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paytaxes;

import java.util.Scanner;
/** 
 *
 * @author Ezzeldin
 */
public class PayTaxes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      double cash;
      double taxes;
      Scanner input =new Scanner(System.in);
        System.out.println("Enter the number of the budget");
        cash =input.nextDouble();
        taxes =cash*0.6;
        System.out.println("the taxes ="+ (int)(taxes*100)/100.00);
    }
    
}
