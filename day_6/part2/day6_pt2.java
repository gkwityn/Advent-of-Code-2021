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
            int spawn = 0;

            for(int i = 0; i < input.length; i++){
                if(input[i] == 0 ){
                    input[9] = input[9]++; 
                }
                else{
                    int current = input.get(i);
                    current--;
                    input.set(i, current);
                }
            }

            for(int i = 0; i < spawn; i++){
                input.add(8);
            }


            print_State(input, "After " + day + " days: ");
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
