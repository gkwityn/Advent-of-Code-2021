public class value {

    private int number;
    private boolean status;


    public value(int number, boolean status){
        number = number;
        status = status;
    }

    public value(){
        number = 0;
        status = false;
    }

    public void setNumber(int number){
        number = number;
    }

    public int getNumber(){
        return number;
    }

    public void setStatus(boolean bool){
        status = bool;
    }

    public boolean getStatus(){
        return status;
    }

    public String toString(){
        String str = "Number: " + number + ", " + 
                     "Status: " + status; 
        return str;
    }

}
