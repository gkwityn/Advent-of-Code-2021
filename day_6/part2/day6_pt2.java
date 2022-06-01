import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import static java.lang.System.out;



public class day6_pt2 {

    public static void read_input(int[] input){
        try{
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            
            String inputStr = scan.nextLine();
            
            StringTokenizer tokenList = new StringTokenizer(inputStr, ",");
            
            int i = 0;
            while(tokenList.hasMoreTokens()){
                input[i++] = Integer.parseInt( tokenList.nextToken());
            }

            scan.close();

        }
        catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(1);            
        }
        
    }


    public static void run_Simulation(int[] input){
        for(int day = 1; day <= 80; day++){

            System.out.println(input[day] + "After " + day + " days: ");
        }

    }


    public static void how_many_fish(ArrayList<Integer> input){

    System.out.println("\n********************");
    System.out.println("Total: " + input.size());
    System.out.println("********************");
}


    public static void main(String[] args) {

        //Array indices 0-9 representing internal timer in days.
        //Value in index represents number of fish of that internal timer.
        int[] input = new int[9];

        read_input(input);
        
        for(int x: input){
            out.print(x +" ");
        }

        
       

    }

}
