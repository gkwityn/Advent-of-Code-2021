import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

@SuppressWarnings("unchecked")

public class day5_pt1 {

    public static void fileIO() {
        
        try{
            File file = new File("sample_input.txt");
            Scanner scan = new Scanner(file);            

            

            while(scan.hasNextLine()){
                int x1, x2, y1, y2;
                String line = scan.nextLine();
                String format= line.replace(" -> ", ",");
                StringTokenizer token = new StringTokenizer(format, ",");
                
                x1 = Integer.parseInt(token.nextToken());
                y1 = Integer.parseInt(token.nextToken());
                x2 = Integer.parseInt(token.nextToken());                
                y2 = Integer.parseInt(token.nextToken());
                
                //Rearange line ends into increasing order.
                if(x2 < x1){
                    int tempX = x2;
                    x2 = x1;
                    x1 = tempX;
                }
                
                if(y2 < y1){
                    int tempY = y2;
                    y2 = x1;
                    y1 = tempY;
                }
                
                //Build Start and End point Array:  ar[x,y]
                int[]p_Start = new int[2];
                p_Start[0]=x1;
                p_Start[1]=y1;

                int[]p_End = new int[2];
                p_End[0] = x2;
                p_End[1] = y2;

                //Check for straight or vertial line
                if(x1 == x2 || y1 == y2){
                    //Build line in x direction
                    if(x1 != x2){
                        
                    }
                    
                }


                
            }

            scan.close();           
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File Not Found");
            System.exit(0);
        }
    }


   


    public static void main(String[] args) {

        fileIO();
   



    }
        
       
}
