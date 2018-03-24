import java.util.*;
public class queue <Type>{
    Stack sk1 = new Stack();
    Stack sk2 = new Stack();
    // push method for queue
    public void push(Type item){
        sk1.push(item);
    }
    //
    public Type pop(){
        while(!sk1.isEmpty()) {
            sk2.push(sk1.pop());
        }
        return (Type) sk2.pop();

    }
    public static void main(String[] args) {
        queue<Integer> qu = new queue<>();
        qu.push(1);
        qu.push(3);
        qu.push(2);
        qu.push(8);
        qu.push(9);
        System.out.println(qu.pop());
        System.out.println(qu.pop());
    }
}