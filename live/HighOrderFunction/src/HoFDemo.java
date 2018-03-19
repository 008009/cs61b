import java.awt.*;

public class HoFDemo {
    public static int do_twice (IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        int x = 10;
        TenX f = new TenX();
        System.out.println(do_twice(f,x));
    }
}