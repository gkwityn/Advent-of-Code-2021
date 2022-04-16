public class LineObj {   

    int x1;
    int x2;
    int y1;
    int y2;
    
    public LineObj(){
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
    }

    public LineObj(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void printLine(){
        System.out.println("x1: "+x1+", x2: "+x2+", y1: "+y1+", y2:"+y2);
    }

    public String toString(){
        return "x1: "+x1+", x2: "+x2+", y1: "+y1+", y2:"+y2;
    }
}
