/*
    Suppose we wanted a data structure SortedStack that takes in integers, and maintains them in sorted order.
    SortedStack supports two operations: push(int i) and pop().
    Pushing puts an int onto our SortedStack, and popping returns the next smallest item in the SortedStack.
    For example, if we inserted 10, 4, 8, 2, 14, and 3 into a SortedStack,
    and then popped everything off, we would get 2, 3, 4, 8, 10, 14.
 */
import java.util.Stack;
public class SortedStack<Item extends Comparable<Item>> {
    private Stack<Item> s1;
    private Stack<Item> s2;

    public SortedStack(){
        s1 = new Stack<Item>();
        s2 = new Stack<Item>();
    }

    public void push(Item element) {
        while(!s1.isEmpty()) {
            if(s1.peek().compareTo(element) < 0) {  //the first time to pop in s1 < the element to be pushed
                s2.push(s1.pop());   // pop the smaller element in s2
            }
            else{
                break;
            }
        }
        s1.push(element);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    public Item pop(){
        return s1.pop();
    }

    public static void main(String[] args) {
        SortedStack<Integer> test = new SortedStack<>();
        test.push(10);
        test.push(4);
        test.push(8);
        test.push(2);
        test.push(14);
        test.push(3);

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
