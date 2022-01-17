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


    public void add(int num, int r, int c){

        numbersList[r][c].setNumber(num);
        numbersList[r][c].setStatus(false);
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

    public int getNumber(int r, int c){
        return numbersList[r][c].getNumber();
    }


    public void setStatus(int r, int c, boolean bool){
        numbersList[r][c].setStatus(bool);
    }

    public boolean getStatus(int r, int c){
        return numbersList[r][c].getStatus();
    }
}
