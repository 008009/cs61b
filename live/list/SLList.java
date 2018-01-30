public class SLList {
	private int size;
	private IntNode sentinel;
	// nested class: you will never use IntNode class outside of the SLList class.
	private static class IntNode {
		// static nested class: static class cannot access outer class's instance variables and methods.
		public int head;
		public IntNode tail;

		public IntNode(int head, IntNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}
	/** normal constructor */
	public SLList (int item) {
		this.sentinel = new IntNode(29, null);
		this.sentinel.tail = new IntNode(item,null);
		size = 1;
	}

	/** constructor for empty list */
	public SLList() {
		this.sentinel = new IntNode(29, null);
		this.sentinel.tail = null;
		size = 0;
	}

	// addfirst method
	public void addfirst(int x) {
		this.sentinel.tail = new IntNode(x, sentinel.tail);
		size++;
	}

	// addlast method 
	public void addlast(int x) {
		size++;
		IntNode temp = this.sentinel;
		while (temp.tail != null) {
			temp = temp.tail;
		}
		temp.tail = new IntNode(x, null);
	}

	// getfirst method
	public int getfirst() {
		return this.sentinel.tail.head;
	}

	// getlast method
	public int getlast(){
		IntNode temp = this.sentinel;
		while(temp.tail != null) {
			temp = temp.tail;
		}
		return temp.head;
	}
/*
	//get size of the SLList
	public int getsize() {
		IntNode temp = this.node;
		int count = 1;
		while(temp.tail != null) {
			temp = temp.tail;
			count++;
		}
		return count;
	}

	// get size of the SLList recursive
	public int recursivesize() {
		return helper(this.node);
	}
	// helper function for getsize
	private static int helper(IntNode p) {
		if (p.tail == null) {
			return 1;
		}
		return 1 + helper(p.tail);
	}
*/
	public int recordsize() {
		return size;
	}

	//test
	public static void main(String[] args) {
		SLList P = new SLList();
		P.addfirst(20);
		P.addfirst(30);
		P.addlast(15); 
		System.out.println(P.getfirst());  
		System.out.println(P.getlast());
		System.out.println(P.recordsize());
	}
}