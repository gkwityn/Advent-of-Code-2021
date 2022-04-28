import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

@SuppressWarnings("unchecked")

public class day5_pt1 {

    public static int xMax = 0;
    public static int yMax = 0;

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

               //System.out.println("Original");
               //System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2);

                //Find the max for determining grid size.
                xMax = findxMax(xMax, x1, x2);                
                yMax = findxMax(yMax, y1, y2);

                //Skip non Horizontal or vertical line.
                if(x1 != x2 && y1 != y2){
                    //System.out.printf("Skipping line\n\n");
                    continue;
                }
                
                //Format coordinates to move in positive direction
                if(x1 == x2){
                    if(y1 > y2){
                        int temp = y1;
                        y1 = y2;
                        y2 = temp;
                    }              
                }
                else if(y1 == y2){
                    if(x1 > x2){
                        int temp = x1;
                        x1 = x2;
                        x2 = temp;
                    }
                }

                //System.out.println("Updated");
                //System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2 +"\n");   
                
                int[][]point = new int[1][1];
                ArrayList<int[][]> line = buildLine(line, x1, y1, x2, y2);
                
            }

            scan.close();           
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File Not Found");
            System.exit(0);
        }
    }

    //TODO
    //Build the line arraylist
    public static ArrayList buildLine(ArrayList line, int x1, int y1, int x2, inty2)){

        return line;
    }

    public static int findxMax(int xMax, int x1, int x2){
        
        if( (x1 > xMax) | (x2 > xMax) ){
            if(x1 > x2){
                return x1;
            }
            else{
                return x2;
            }          
        }
        return xMax;
    }

    public static int findyMax(int yMax, int y1, int y2){
        
        if((y1 > yMax) | ( y2 > yMax)){
            if(y1>y2){
                return y1;
            }else{
                return y2;
            }         
        }
        return yMax;
    }

    public static void print_grid(){
        for(int x = 0; x < xMax; x++){
            for(int y = 0; y < yMax; y++){
                System.out.printf(".");
            }
            System.out.printf("\n");
        }
    }
   


    public static void main(String[] args) {
        
        fileIO();
   
        //System.out.println("Final xMAx: " + xMax);
        //System.out.println("Final yMAx: " + yMax);

        print_grid();

    }
        
       
}
