/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        //return a==b;
        /**
         *  == between Integer, Long etc. are checking the reference equality.
         */
        return a.equals(b);
    }
}
