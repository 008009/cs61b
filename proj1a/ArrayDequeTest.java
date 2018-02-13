public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void test() {
        System.out.println("Running add/isEmpty/Size test.");
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        boolean passed = checkEmpty(true, ad.isEmpty());
//        ad.addLast(3);
//        ad.addLast(4);
//        ad.addFirst(8);
//        ad.addFirst(1);
//        ad.removeFirst();
//        ad.removeLast();
//        ad.addLast(2);
//        ad.addLast(10);
//        ad.addFirst(19);
//        ad.addLast(15);
//        ad.addLast(20);
//        ad.addFirst(28);
//        ad.removeLast();
//        ad.removeFirst();

        ad.addFirst(15);
        ad.addFirst(24);
        ad.addFirst(23);
        ad.addFirst(30);
        ad.addFirst(2);
        ad.addFirst(3);

        //19,8,3,2,10,15
        ad.printDeque();
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        test();
    }

}
