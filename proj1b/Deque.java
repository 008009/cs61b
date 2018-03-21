public interface Deque<type> {
    boolean isEmpty();
    int size();
    type get(int index);
    void addFirst(type Item);
    void addLast(type Item);
    void printDeque();
    type removeFirst();
    type removeLast();
}
