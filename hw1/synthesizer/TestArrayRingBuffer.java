package synthesizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        assertEquals(0,arb.fillCount());
        assertTrue(arb.isEmpty());
        //arb.dequeue();
        arb.enqueue(10);
        assertEquals(10,arb.peek());
        arb.enqueue(12);
        arb.enqueue(23); // 10, 12, 23
        assertEquals(10,arb.peek());
        arb.dequeue();
        arb.dequeue(); // 23
        assertEquals(23, arb.peek());
        arb.enqueue(3);// null null 23 3
        arb.enqueue(20); // null null 23 3 20
        arb.enqueue(4);
        arb.enqueue(2); // 4,2,23,3,20
        //arb.enqueue(56); // overflow
        assertEquals(23,arb.peek());
        arb.dequeue(); // 4 2 null 3 20
        arb.dequeue(); // 4 2 null null 20
        arb.dequeue(); // 4 2 null null null
        assertEquals(4,arb.peek());
        assertEquals(2, arb.fillCount());
    }


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }


} 
