public class Grid {
    int x1, x2, y1, y2;
    
    public Grid(){
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
    }
    
    //Set Methods
    public void set_x1(int set){
        this.x1 = set;
    }
    public void set_x2(int set){
        this.x2 = set;
    }
    public void set_y1(int set){
        this.y1 = set;
    }
    public void set_y2(int set){
        this.y2 = set;
    }

    //Get Methods
    public int get_x1(){
       return this.x1;
    }
    public int get_x2(){
        return this.x2;
    }
    public int get_y1(){
        return this.y1;
    }
    public int get_y2(){
        return this.y2;
    }

    public void print_Grid(){
        System.out.println("x1: " + this.x1);
        System.out.println("x2: " + this.x2);
        System.out.println("y1: " + this.y1);
        System.out.println("y2: " + this.y2);
    }

    public void build(){

        for(int x = 0; x <= x2; x++){
            for(int y = 0; y <= y2; y++){

            }
        }

    }



}
