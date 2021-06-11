/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replacestr;
import java.util.*;
import java.io.*;
/**
 *
 * @author Ezzeldin
 */
public class ReplaceStr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        File file =new File("C:\\Users\\Ezzeldin\\Desktop\\Ezz.txt");
        File Newfile =new File("C:\\Users\\Ezzeldin\\Desktop\\NewEzz.txt");
        System.out.println("Hello World");
        if(Newfile.exists())
                System.exit(0);
        try(    Scanner input=new Scanner(file);
                PrintWriter output=new PrintWriter(Newfile)
                )
        {
        while(input.hasNextLine())
        {
            String word=input.nextLine();
          word= word.replaceAll("ezz", "samy");
       output.print(word+ " ");
        }
        }
    }
    
}
