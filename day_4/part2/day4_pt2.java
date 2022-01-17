import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class day4_pt2 {
    
    public static void check_for_hit(String s, board myBoard){
        
        int key = Integer.parseInt(s);
        //System.out.println("Checking board for: " + key );


        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                
                if(myBoard.getNumber(i, j) == key)
                    myBoard.setStatus(i, j, true);
                
            }
        }       
    }

    public static boolean check_for_bingo(board myBoard){
         
        //Check rows for bingo
        for(int row = 0; row < 5; row++){
            if(checkRow(row, myBoard) == true){
                System.out.println("bingo @ row: " + row );
                return true;
            }
        }        

        //Check columns for bingo
        for(int col = 0; col < 5; col++){
            if(checkCol(col, myBoard) == true){
                System.out.println("bingo @ col: " + col );
                return true;
            }
        }

        //Check diagonals
        // if(checkDiagonal(myBoard)){
        //     System.out.println("bingo diag");
        //     return true;
        // }

        return false;
    }

    public static boolean checkRow(int row, board myBoard){
        
        boolean bingo = false;

        for(int col = 0; col < 5; col++){
            if(myBoard.getStatus(row, col) == true){
                bingo = true;
            }
            else{
                return false;
            }
        }
        return bingo;
    }

    public static boolean checkCol(int col, board myBoard){

        boolean bingo = false;

        for(int row = 0; row < 5; row++){
            if(myBoard.getStatus(row, col) == true ){
                bingo = true;
            }
            else{
                return false;
            }
        }
        return bingo;
    }

    public static boolean checkDiagonal(board myBoard){

        boolean diagonalRight = false;

        //Check right hand diagonal
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                if(row == col){
                    if(myBoard.getStatus(row, col) == true){
                        diagonalRight = true;
                    }
                    else{
                        diagonalRight = false;
                        break;
                    }
                }
            }
        }

        boolean diagonalLeft = false;

        //check lefthand diagonal
        for(int row = 4; row >= 0; row--){
            for(int col = 4; col >= 0; col--){
                if(row == col){
                    if(myBoard.getStatus(row, col) == true){
                        diagonalLeft = true;
                    }
                    else{
                        diagonalLeft = false;
                        break;
                    }
                }
            }
        }

        System.out.println("diagRight: " +  diagonalRight + ", diagLeft: " + diagonalLeft);
        return diagonalRight || diagonalLeft;
    }
   
    public static int sum_Unmarked(board myboard){
        int sum = 0;

        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                if(myboard.getStatus(row, col) == false){
                    sum += myboard.getNumber(row, col);
                }
            }
        }
        
        return sum;
    }

    public static void play_game(ArrayList<String> num_drawn, ArrayList<board> boards, ArrayList<board> winning_boards ){

        //check each board for a number hit
        for(int i = 0; i < num_drawn.size(); i++){
            for(int j = 0; j < boards.size(); j++){
                check_for_hit(num_drawn.get(i), boards.get(j));

                
            }        
        }  
        //Check boards for Bingo
        for(int k = 0; k < boards.size(); k++){
            if(check_for_bingo(boards.get(k))){
                System.out.println("Bingo! board#: " + k );
                //System.out.println("Sum of the board is: " + sum_Unmarked(boards.get(k)) );
                //System.out.println("Multiplier: " + num_drawn.get(i));
                //System.out.println("Final: " + sum_Unmarked(boards.get(k)) * Integer.parseInt(num_drawn.get(i)) );
                winning_boards.add(boards.get(k));
                
            }
            else{
                //System.out.println("No bingo found @ index: " + i);
            }
        }

        System.out.println("Winning boards: " + winning_boards.size());

    }
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
            
            ArrayList<board> boards = new ArrayList<board>();

            while(inputFile.hasNext()){
                board myBoard = new board();

                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 5; j++){
                        myBoard.add(inputFile.nextInt(), i, j);
                    }
                }
                boards.add(myBoard);
                //myBoard.printList();       
            }
            
            //Print each board
            // for(int i = 0; i < boards.size(); i++){
            //     boards.get(i).printList();
            //     System.out.println("--------------------\n");
            // }
            
            ArrayList<board> winning_boards = new ArrayList<board>();
            play_game(num_drawn, boards, winning_boards);
            
                 


            //Check boards for Bingo
            // for(int i = 0; i < boards.size(); i++){
            //     if(check_for_bingo(boards.get(i))){
            //         System.out.println("Bingo! board#: " + i );
            //         System.out.println("Sum of the board is: " + sum_Unmarked(boards.get(i)) );
            //     }
            //     else{
            //         //System.out.println("No bingo found @ index: " + i);
            //     }
            // }

            
            
            

            inputFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }

        
        
        





            
        System.exit(0);
    }
    
}
