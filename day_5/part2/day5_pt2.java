import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;


public class day5_pt2 {
    
    public static int xMax = 0;
    public static int yMax = 0;

    public static ArrayList<ArrayList<Point>> fileIO(ArrayList<ArrayList<Point>> lineList) {
        
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
           
                
               
                System.out.println("\nInput: " + x1 + ", " + y1 + ", " + x2 + ", " + y2 );   

                ArrayList<Point> myLine = new ArrayList<Point>();
                myLine = buildLine(myLine, x1, x2, y1, y2);
                lineList.add(myLine);             
            
            }

            scan.close(); 
            return lineList;           
            
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File Not Found");
            System.exit(0);
        }
        return lineList;
    }
    
    public static ArrayList<Point> buildLine(ArrayList<Point> myLine, int x1, int x2, int y1, int y2){
        //TODO 
        //Rework to Build diagonal lines.
        //1,1 -> 3,3 covers points 1,1, 2,2, and 3,3.
        //9,7 -> 7,9 covers points 9,7, 8,8, and 7,9
        /*
        0,9 -> 5,9 : 0,9, 1,9, 2,9, 3,9, 4,9, 5,9 
        8,0 -> 0,8 : 8,0, 7,1, 6,2, 5,3, 4,4, 3,5, 2,6, 1,7, 0,8 
        9,4 -> 3,4 : 9,4, 8,4, 7,4, 6,4, 5,4, 4,4, 3,4
        2,2 -> 2,1 : 2,2, 2,1
        7,0 -> 7,4 : 7,0, 7,1, 7,2, 7,3, 7,4 
        6,4 -> 2,0 : 6,4, 
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8 : 0,0, 1,1
        5,5 -> 8,2
        */

      //Build a Vertical Set of Points
      if(x1 == x2){
        if(y1 < y2){
            System.out.println("x1=x2, y1<y2");
            for(int y = y1; y <= y2; y++){
                Point myPoint = new Point(x1, y);
                myPoint.printPoint();
                myLine.add(myPoint);                                      
            }
        }
        else if(y2 < y1){
            System.out.println("x1=x2, y2<y1");
            for(int y = y2; y <= y1; y++){
                Point myPoint = new Point(x1, y);
                myPoint.printPoint();
                myLine.add(myPoint);                                     
            }
        }
        return myLine;
    }
    //Build a Horizontal Set of Points
    if(y1 == y2){
        if(x1 < x2){
            System.out.println("y1=y2, x1<x2");
            for(int x = x1; x <= x2; x++){
                Point myPoint = new Point(x, y1);
                myPoint.printPoint();
                myLine.add(myPoint);
            }
            return myLine;
        }
        else if(x2 < x1){
            System.out.println("y1=y2, x2<x1");
            for(int x = x2; x <= x1; x++){
                Point myPoint = new Point(x, y1);
                myPoint.printPoint();
                myLine.add(myPoint);
            }
        }
        return myLine;
    }



        /*
        //Build diagonal line.
        if(x1 < x2 && y1 < y2){
            for(int x = x1; x1 <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    Point myPoint = new Point(x, y);
                    myPoint.printPoint();
                    myLine.add(myPoint);  
                }
            }
            return myLine;
        }
        
        else if(x1 < x2 && y1 > y2){
            for(int x = x1; x1 <= x2; x++){
                for(int y = y2; y >= y1; y--){
                    Point myPoint = new Point(x, y);
                    myLine.add(myPoint);  
                }
            }
            return myLine;
        }
        else if(x1 > x2 && y1 < y2){
            for(int x = x2; x >= x1; x--){
                for(int y = y1; y <= y2; y++){
                    Point myPoint = new Point(x, y);
                    myLine.add(myPoint);  
                }
            }
            return myLine;
        }
        else if(x1 > x2 && y1 > y2){
            for(int x = x2; x >= x1; x--){
                for(int y = y2; y >= y1; y--){
                    Point myPoint = new Point(x, y);
                    myLine.add(myPoint);  
                }
            }
            return myLine;
        }  
        */     
        

  
        

        //Print Line Points
        // for(Point point: myLine){
        //     point.printPoint();
        // }
        // System.out.println("\n");

        return myLine;
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

    public static void print_grid(int[][] grid){

        for(int y = 0; y <= yMax; y++ ){
        for(int x = 0; x <= xMax; x++ ){
                            
                    System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }   
    }

    public static int[][] buildGrid(int[][] grid){

        grid = new int[xMax+1][yMax+1];

        for(int x = 0; x <= xMax; x++ ){
            for(int y = 0; y <= yMax; y++ ){
                grid[x][y] = 0;
            }
        }

        return grid;
    }
   
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Point>> lineList = new ArrayList<ArrayList<Point>>();

        lineList = fileIO(lineList);      

        //Print Line Points
        /*
        for(ArrayList<Point> line: lineList){
            System.out.println("\nPoint:");
            for(Point point: line){
                point.printPoint();
            }
        }
        //System.out.println("Final xMAx: " + xMax);
        //System.out.println("Final yMAx: " + yMax);
        */
               
        int[][] grid = null;
        grid = buildGrid(grid);
        //print_grid(grid);

        //Iterate through each line and increment grid where point is found.
        for(ArrayList<Point> line: lineList){            
            for(Point point: line){
               grid[point.getX()][point.getY()]++;  
            }
        }
        
        //Count the  instances/coordinates of line overlap
        int count = 0;
        for(int[] line: grid){
            for(int point: line){
                if(point >= 2){
                    count++;
                }
            }
        }

        System.out.println("N Overlaps: "+ count);
        //print_grid(grid);
            

        



    }
}
