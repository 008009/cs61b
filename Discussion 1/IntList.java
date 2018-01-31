public class IntList {
	public int head;
	public IntList tail;

	public IntList(int head, IntList tail) {
		this.head = head;
		this.tail = tail;
	}

	/** recursion method to calculate the size of the IntList */
	public int size1() {
		//find the base case for the recursion 
		if(this.tail == null) {
			return 1;
		}
		return 1 + this.tail.size1();
	}

	/** iterative method */
	public int size2(){
		/** key point */
		IntList temp = this;
		/** key point */
		int length = 0;
		while (temp != null) {
			length += 1;
			temp = temp.tail;		
		}
		return length;
	}

	/** get method to return the Nth number of the list */
	public int get1(int n) {
		if(n + 1 > this.size1()) {
			System.out.println("out of the bound!");
		}
		int temp = 0;
		IntList P = this;
		while(temp < n) {
			P = P.tail;
			temp++;
		}
		return P.head; 		
	}

	/** get method using recusion */
	public int get2(int n){
		if(n + 1 > this.size1()) {
			System.out.println("out of the bound!");
		}
		if(n == 0){
			return this.head;
		}
		return this.tail.get2(n-1);
	}

	/** Destructively squares each element of the given IntList L. Don’t use ’new’; modify the original IntList. Should be written iteratively. */
	public static IntList SquareDestructive(IntList L) {
		if (L == null) {
			return null;
		}
		while(L.tail != null) {
			L.head *= L.head;
			L = L.tail;
		}
		L.head = L.head;
		return L;
	}

	/** Destructively squares recursively */ 
	public static IntList RecursiveSquareDestructive(IntList L) {
		if (L.tail == null){
			L.head *= L.head;
			return L;
		}else {
			L.head *= L.head;
			L.tail = RecursiveSquareDestructive(L.tail);
			return L;
		}
	}

	/** Non-destructively squares each element of the given IntList L. Don’t modify the given IntList. Should be written recursively*/
	public static IntList RecursiveSquareNonDestructive(IntList L) {
		if (L == null) {
			return L;
		}
		IntList result = new IntList(L.head*L.head, RecursiveSquareNonDestructive(L.tail));
		return result;
	} 

	/** SquareNonDestructive non-recursive version */
	public static IntList SquareNonDestructive(IntList L) {
		if(L == null) {
			return null;
		}
		IntList result = new IntList(L.head*L.head, null);
		IntList B = L.tail;	// pointer for L 
		IntList C = result; // pointer for result, result and C point to the same memory address 
		while(B != null) {
			C.tail = new IntList(B.head*B.head, null);
			B = B.tail;
			C = C.tail;
		}
		return result;
	}

	//test
	public static void main(String[] args) {
		IntList P = new IntList (1, null);
		P = new IntList(2, P);
		P = new IntList(3, P);
		P = new IntList(4, P);
		//SquareDestructive(P);
		//RecursiveSquareDestructive(P);
		//RecursiveSquareNonDestructive(P);
		RecursiveSquareNonDestructive(P);

		System.out.println(P.size1());
		System.out.println(P.size2());
		System.out.println(P.get2(0));
		System.out.println(P.get2(1));
		System.out.println(P.get2(2));
		System.out.println(P.get2(3));
	}
}