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
            File file = new File("input.txt");
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
           
                
               
                System.out.println("\n\nInput: " + x1 + ", " + y1 + ", " + x2 + ", " + y2 );   

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

    //Build a Vertical Set of Points
    if(x1 == x2){
        if(y1 < y2){
            //System.out.println("x1=x2, y1<y2");
            for(int y = y1; y <= y2; y++){
                Point myPoint = new Point(x1, y);
                myPoint.printPoint();
                myLine.add(myPoint);                                      
            }
        }
        else if(y2 < y1){
            //System.out.println("x1=x2, y2<y1");
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
            //System.out.println("y1=y2, x1<x2");
            for(int x = x1; x <= x2; x++){
                Point myPoint = new Point(x, y1);
                myPoint.printPoint();
                myLine.add(myPoint);
            }
            return myLine;
        }
        else if(x2 < x1){
            //System.out.println("y1=y2, x2<x1");
            for(int x = x2; x <= x1; x++){
                Point myPoint = new Point(x, y1);
                myPoint.printPoint();
                myLine.add(myPoint);
            }
        }
        return myLine;
    }


    //Build one of 4 different diagonal lines.
    if(x1 < x2 && y1 < y2){
        //System.out.println("Diagonal: x1 < x2, y1 < y2");
        for(int x = x1; x <= x2; x++){
            for(int y = y1; y <= y2; y++){
                Point myPoint = new Point(x, y);
                myPoint.printPoint();
                myLine.add(myPoint);
                x++; 
            }
        }
        return myLine;
    }
    else if(x1 < x2 && y1 > y2){
       //System.out.println("Diagonal: x1 < x2, y1 > y2");
        for(int x = x1; x <= x2; x++){
            for(int y = y1; y >= y2; y--){
                Point myPoint = new Point(x, y);
                myPoint.printPoint();
                myLine.add(myPoint);  
                x++;
            }
        }
        return myLine;
    }
    else if(x1 > x2 && y1 < y2){
        //System.out.println("Diagonal: x1 > x2, y1 < y2");
        for(int x = x1; x >= x2; x--){
            for(int y = y1; y <= y2; y++){
                Point myPoint = new Point(x, y);
                myPoint.printPoint();
                myLine.add(myPoint);  
                x--;                
            }
        }
        return myLine;
    }
    else if(x1 > x2 && y1 > y2){
        //System.out.println("Diagonal: x1 > x2, y1 > y2");
        for(int x = x1; x >= x2; x--){
            for(int y = y1; y >= y2; y--){
                Point myPoint = new Point(x, y);
                myPoint.printPoint();
                myLine.add(myPoint);  
                x--;
            }
        }
        return myLine;
    }  


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
        System.out.println("\n\n****************************");
        System.out.println("N Overlaps: "+ count);
        System.out.println("****************************");
    }
}
