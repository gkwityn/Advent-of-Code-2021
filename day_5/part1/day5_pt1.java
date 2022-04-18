import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("unchecked")

public class day5_pt1 {

    public static void fileIO(ArrayList lineList, Grid mygrid) {
        
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


                //x1_grid && y1_grid vertex = 0

                //Expand the grid size to max x & y
                if(x1 >= mygrid.get_x2()){
                    mygrid.set_x2(x1);
                }
                if(x2 >= mygrid.get_x2()){
                    mygrid.set_x2(x2);
                }

                if(y1 >= mygrid.get_y2()){
                    mygrid.set_y2(y1);
                }
                if(y2 >= mygrid.get_y2()){
                    mygrid.set_y2(y2);
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
        Grid mygrid = new Grid();
        
        fileIO(lineList, mygrid);

        mygrid.print_Grid();

        int overlapSum = 0;
        findOverlap(overlapSum, lineList);      



    }
        
       
}
