public class Point {

    int x,y,value;

    public Point(){
        this.x = 0;
        this.y = 0;
        this.value = 0;
    }

    public Point(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public void incrementValue(){
        this.value++;
    }

    public int getValue(){
        return this.value;
    }
}
