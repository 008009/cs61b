// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    public Iterator<T> iterator(){
        return new myIterator();
    }

    public class myIterator implements Iterator<T>{
        int currentIndex;

        public myIterator(){
            currentIndex = 0;
        }

        public T next(){
            T result = rb[currentIndex];
            currentIndex++;
            return result;
        }

        public boolean hasNext(){
            return currentIndex >= capacity;
        }

    }
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */

    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[])new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if(fillCount >= capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last++;
        if(last >= capacity) {
            last = last % capacity;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first
        if(isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T result = rb[first];
        rb[first] = null;
        first++;
        if(first >= capacity) {
            first = first % capacity;
        }
        fillCount--;
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    public boolean isFull(){
        return fillCount == capacity;
    }

    public boolean isEmpty(){
        return fillCount == 0;
    }

    
    //test for iterator
    public static void main(String[] args){
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        arb.enqueue(23);
        arb.enqueue(2);
        arb.enqueue(39);
        arb.enqueue(15);
        arb.enqueue(30);

        Iterator test = arb.iterator();
        while(!test.hasNext()){
            System.out.println(test.next());
        }
    }
}
