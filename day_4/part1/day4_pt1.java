import java.io.*;
import java.util.Scanner;
public class day4_pt1 {    

    public static void main(String[] args) {

        try{
            File fp = new File("sample_input.txt", "r");
            Scanner inputFile = new Scanner(fp);
            String line = inputFile.nextLine();

            inputFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }   




            
        System.exit(0);
    }
    
}
