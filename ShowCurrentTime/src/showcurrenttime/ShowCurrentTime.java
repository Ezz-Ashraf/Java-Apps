/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showcurrenttime;

/**
 *
 * @author Ezzeldin
 */
public class ShowCurrentTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Hello this program shows the current time");
       long passedMillis = System.currentTimeMillis();
       long passedSeconds= passedMillis/1000;
       long CurrentSeconds =passedSeconds%60;
       long passedMinutes =passedSeconds/60;
       long CurrentMinutes=passedMinutes%60;
       long passedHours=passedMinutes/60;
       long CurrentHours=passedHours%24;
       System.out.println("The time now is " + CurrentHours +":" + CurrentMinutes +":" +CurrentSeconds + " GMT");
    }
    
}
