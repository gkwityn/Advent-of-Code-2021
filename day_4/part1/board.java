public class board {

    private int rows;
    private int columns;
    private value[][] numbersList;
    

    public board(){
        rows = 5;
        columns = 5;          
        numbersList = new value[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                numbersList[i][j] = new value();
            }
        }
    }


    public void add(int num, int row, int col){

        numbersList[row][col].setNumber(num);
        numbersList[row][col].setStatus(false);
    }


    public void printList(){

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(numbersList[i][j].getNumber() + ", " + 
                                 numbersList[i][j].getStatus()+ " ");
            }
            System.out.println();
        }
        
    }

    public int getNumber(int row, int col){
        return numbersList[row][col].getNumber();
    }


    public void setStatus(int row, int col, boolean bool){
        numbersList[rows][col].setStatus(bool);
    }

    
}
