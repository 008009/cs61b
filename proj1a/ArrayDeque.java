/** 1. write the plusOne and minousOne function to calculate the nextfirst and nextlast index.
 *  2. getrealIndex function is very tricky.
 *  3. figure out the way to arraycopy in resize function. nextfirst + 1 must be the first index of the array. nextLast - 1 must be the last index of the array.
 *  4. Please contact me if you find any bugs.
 * @param <type>
 */
public class ArrayDeque <type> {
    public type[] item;
    public int size;
    public int startingsize = 8;
    public int resizefactor = 2;
    public int nextfirst = 0;
    public int nextlast = 1;

    // constructor for empty ArrayDeque
    public ArrayDeque() {
        size = 0;
        item = (type[]) new Object[startingsize];
    }

    // isEmpty function
    public boolean isEmpty() {
        return size == 0;
    }

    // find the size of array function
    public int size() {
        return size;
    }

    // resize the array
    public void resize(int newlength) {
        type[] temp = this.item;
        type[] a = (type[]) new Object[newlength];
        int indexfirst = plusOne(nextfirst);
        if(indexfirst != 0) {
            System.arraycopy(temp,indexfirst,a,0,this.size-indexfirst);
            System.arraycopy(temp,0,a,this.size-indexfirst,indexfirst);
            //System.arraycopy(items, indexFirst, newArray, 0, items.length - indexFirst);
            //System.arraycopy(items, 0, newArray, items.length - indexFirst, size - items.length + indexFirst);
        }
        else {
            System.arraycopy(this.item, 0,a,0, this.size);
        }
        this.item = a;
        this.nextfirst = newlength - 1;
        this.nextlast = this.size;
    }

    // addFirst function
    public void addFirst(type Item) {
        type[] temp = this.item;
        if(this.size < temp.length) {
            temp[nextfirst] = Item;
            nextfirst = minusOne(nextfirst);
        }
        else{
            resize(this.size*resizefactor);
            this.item[nextfirst] = Item;
            nextfirst = minusOne(nextfirst);
        }
        this.size++;
    }

    public void addLast(type Item) {
        type[] temp = this.item;
        if(this.size < temp.length) {
            temp[nextlast] = Item;
            nextlast = plusOne(nextlast);
        }
        else{
            resize(this.size*resizefactor);
            this.item[nextlast] = Item;
            nextlast = plusOne(nextlast);
        }
        this.size++;
    }

    public int plusOne(int index) {
        type[] temp = this.item;
        int addIndex = index + 1;
        if(addIndex >= temp.length) {
            addIndex = addIndex % this.item.length;
        }
        return addIndex;
    }

    public int minusOne(int index) {
        type[] temp = this.item;
        int minusIndex = index - 1;
        if(minusIndex < 0) {
            minusIndex += temp.length;
        }
        return minusIndex;
    }

    //tricky one
    public int getrealIndex(int index) {
        return (index + nextfirst + 1) % (this.item.length);
    }

    // ??  Gets the item at the given index
    public type get(int index) {
        if(index < this.size) {
            return item[getrealIndex(index)];
        }
        return null;
    }

    public void printDeque() {
        for(int i = 0; i < this.size; i++) {
            System.out.print(get(i) + " ");
        }
    }
    public type removeFirst() {
        if(isEmpty()) {
            return null;
        }
        type[] temp = this.item;
        int firstIndex = plusOne(nextfirst);
        type removeditem = temp[firstIndex];
        temp[firstIndex] = null;
        nextfirst =  firstIndex;
        this.size--;
        if(temp.length > 16) {
            if(this.size / temp.length < 0.25) {
                resize(temp.length/resizefactor);
            }
        }
        return removeditem;
    }

    public type removeLast() {
        if(isEmpty()){
            return null;
        }
        type[] temp = this.item;
        int lastindex = minusOne(nextlast);
        type itemremoved = temp[lastindex];
        temp[nextlast] = null;
        nextlast = lastindex;
        this.size--;
        if(temp.length > 16) {
            if(this.size / temp.length < 0.25) {
                resize(temp.length/resizefactor);
            }
        }
        return itemremoved;
    }
}