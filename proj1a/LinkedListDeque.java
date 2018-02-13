/** This one is pretty easy comparing with ArrayDeque.
 *  Please contact me if you find any bugs.
 *
 * @param <type>
 */
public class LinkedListDeque <type> {
    private int size;
    private node sentinel;

    //inside magic
    private class node{
        public node prev;
        public type item;
        public node next;

        public node(node prev, type item, node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
        public type helper(int i ){
            node temp = this;
            if(i == 0) {
                return temp.item;
            }else{
                temp = temp.next;
                return temp.helper(i-1);
            }
        }
    }

    // constructor for an empty linked list deque
    public LinkedListDeque() {
        size = 0;
        sentinel = new node(this.sentinel, null, this.sentinel);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!

    public type get(int index) {
        if(index >= size) {
            return null;
        }
        else{
            node temp = this.sentinel.next;
            for(int i = 0; i < size; i++) {
                if(i != index) {
                    temp = temp.next;
                    continue;
                }else{
                    break;
                }
            }
            return temp.item;
        }
    }

    // recursive get
    public type getRecursive(int index) {
        node temp = this.sentinel.next;
        return temp.helper(index);
    }

    // addFirst method  Adds an item to the front of the Deque.
    public void addFirst(type Item) {
        if (this.isEmpty()) {
            node firstnode = new node(this.sentinel, Item, this.sentinel);
            this.sentinel.next = firstnode;
            this.sentinel.prev = firstnode;

        } else {
            node oldfirstnode = this.sentinel.next;
            node newfirstnode = new node(this.sentinel, Item, oldfirstnode);
            this.sentinel.next = newfirstnode;
            oldfirstnode.prev = newfirstnode;
        }
        this.size++;
    }

    // addLast method
    public void addLast(type Item) {
        if(this.isEmpty()) {
            this.addFirst(Item);
        }else{
            node oldelastnode = this.sentinel.prev;
            node newlastnode = new node(oldelastnode, Item, this.sentinel);
            oldelastnode.next = newlastnode;
            this.sentinel.prev = newlastnode;
        }
        this.size++;
    }

    //Prints the items in the Deque from first to last
    public void printDeque() {
        node p = this.sentinel.next;
        while(p != sentinel) {
            System.out.println(p.item + " ");
            p = p.next;
        }
    }

    //Removes and returns the item at the front of the Deque
    public type removeFirst() {
        if(this.isEmpty()) {
            return null;
        }
        node oldfirstnode = this.sentinel.next;
        node oldfirsttwonode = oldfirstnode.next;
        oldfirsttwonode.prev = this.sentinel;
        this.sentinel.next = oldfirsttwonode;
        oldfirstnode.prev = null;
        oldfirstnode.next = null;
        size--;
        return oldfirstnode.item;
    }

    //Removes and returns the item at the back of the Deque
    public type removeLast() {
        if(this.isEmpty()) {
            return null;
        }
        node oldbacknode = this.sentinel.prev;
        node lasttwonode = oldbacknode.prev;
        lasttwonode.next = this.sentinel;
        this.sentinel.prev = lasttwonode;
        oldbacknode.prev = null;
        oldbacknode.next = null;
        size--;
        return oldbacknode.item;
    }
}