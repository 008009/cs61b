package byog.Core;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void printPoint(Point x){
        System.out.println("(" + x.x + " , " + x.y + ")");
    }
}
