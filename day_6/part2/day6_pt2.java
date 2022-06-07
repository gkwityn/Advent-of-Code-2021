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
            File file = new File("sample_input.txt");
            Scanner scan = new Scanner(file);
            
            String inputStr = scan.nextLine();
            
            StringTokenizer tokenList = new StringTokenizer(inputStr, ",");
        
            while(tokenList.hasMoreTokens()){
                int temp = Integer.parseInt( tokenList.nextToken());
                input[temp] = input[temp]+1;
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


            for(int i = input.length-1; i >= 0; i++){
                if(i > 0){
                    input[i] = input[i+1];
                    continue;
            for(int i = 0; i < input.length; i++){
                if(input[i] == 0 ){
                    input[9] = input[9]++;
                }
                else if (i == 0 ) {
                    input[i] = input[i+1];
                    input[input.length] = input[0];
                } else {
                    
                }
            }
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

        //Initialize Array to all zeros
        for(int i =0; i < input.length; i++){
            input[i] = 0;
        } 
           

        read_input(input);
        
        for(int i = 0; i < input.length; i++ ){
            out.println("Index " + i + ": " + input[i]);
        }

        
       

    }

}
