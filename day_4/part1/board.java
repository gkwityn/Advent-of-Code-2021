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

    
}
