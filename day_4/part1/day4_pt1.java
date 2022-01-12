import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class day4_pt1 {
    
    public static void check_board(int key, board myBoard){
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                
                if(myBoard.getNumber(i, j) == key)
                    myBoard.setStatus(i, j, true);
                
            }
        }       

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
            
            for(int i = 0; i < boards.size(); i++){
                boards.get(i).printList();
                System.out.println("--------------------\n");
            }            

            inputFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        





            
        System.exit(0);
    }
    
}
