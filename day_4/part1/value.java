public class value {

    private int number;
    private boolean status;


    public value(int number, boolean status){
        this.number = number;
        this.status = status;
    }

    public value(){
        number = 0;
        status = false;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public void setStatus(boolean bool){
        this.status = bool;
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
