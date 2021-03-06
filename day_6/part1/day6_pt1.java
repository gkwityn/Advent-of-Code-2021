import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;



public class day6_pt1 {

    public static void read_input(ArrayList<Integer> input){
        try{
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            
            String inputStr = scan.nextLine();
            
            StringTokenizer tokenList = new StringTokenizer(inputStr, ",");
            
            while(tokenList.hasMoreTokens()){
                input.add(Integer.parseInt( tokenList.nextToken()));
            }

            scan.close();

        }
        catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(1);            
        }
        
    }


    public static void print_State(ArrayList<Integer> input, String state){
       
        System.out.print(state);
        for(int x: input){
            System.out.print(x+" ");
        }
        System.out.println();
    }


    public static void run_Simulation(ArrayList<Integer> input){
        for(int day = 1; day <= 80; day++){
            int spawn = 0;

            for(int i = 0; i < input.size(); i++){
                if(input.get(i) == 0 ){
                    spawn++;
                    input.set(i, 6);
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

        ArrayList<Integer> input = new ArrayList<Integer>();

        read_input(input);
        print_State(input, "Initial State: ");
        run_Simulation(input);
        how_many_fish(input);


        
       

    }

}
