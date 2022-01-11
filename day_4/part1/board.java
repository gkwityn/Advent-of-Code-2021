public class board {

    private int rows;
    private int columns;
    private int index;
    private value[][] numbersList;
    

    public board(){
        rows = 5;
        columns = 5;  
        index = 0;
        
        numbersList = new value[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                numbersList[i][j] = new value();
            }
        }
    }

    public void add(int num){
        int thisRow = index / 
        this.numbersList
    }

    
}
