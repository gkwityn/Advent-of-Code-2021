import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

@SuppressWarnings("unchecked")

public class day5_pt1 {

    public static void fileIO(ArrayList lineList, int x_max, int y_max) {
        
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
                
                //Check for straight or vertial line
                if(x1 == x2 || y1 == y2){
                    LineObj myLine = new LineObj(x1,x2,y1,y2);                
                    lineList.add(myLine);  
                }


                if(x1 >= x_max){
                    x_max = x1;
                }

                if(x2 >= x_max){
                    x_max = x2;
                }

                if(y1 >= y_max){                    
                    y_max = y1;
                }

                if(y2 >= y_max){
                    y_max = y2;
                }
            }

            scan.close();           
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File Not Found");
            System.exit(0);
        }
    }


    public static int findOverlap(int overlapSum, ArrayList<LineObj>lineList){
        int inputSize = lineList.size();
        
        for(int i=0; i < inputSize; i++){
            for(int j =0; j <inputSize; j++){

                

            }
        }
        return inputSize;
    }


    public static void main(String[] args) {

        ArrayList<LineObj> lineList = new ArrayList<>();
        
        int x_max, y_max;
        x_max = y_max = 0;
        
        
        fileIO(lineList, x_max, y_max);

        System.out.println(x_max + ", " + y_max);


        

        int overlapSum = 0;
        findOverlap(overlapSum, lineList);      



    }
        
       
}
