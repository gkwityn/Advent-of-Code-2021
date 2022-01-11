import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class day4_pt1 {    

    public static void main(String[] args) {

        try{
            File fp = new File("sample_input.txt");
            Scanner inputFile = new Scanner(fp);


            String line = inputFile.nextLine();

            ArrayList<String> num_drawn = new ArrayList<String>();
            StringTokenizer token = new StringTokenizer(line, ",");

            while(token.hasMoreTokens() ){
                num_drawn.add(token.nextToken());
            }

            inputFile.n

            board myBoard = new board();
            for(int i = 0; i < 6; i++){
                line = inputFile.nextLine();
                token = new StringTokenizer(line, ",");
                board.numbersList
                System.out.println(line);
            }


            

            inputFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }   




            
        System.exit(0);
    }
    
}
