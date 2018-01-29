public class SLList {
	private IntNode node;
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

	public SLList (int item) {
		this.node = new IntNode (item, null);
	}

	// addfirst method
	public void addfirst(int x) {
		this.node = new IntNode(x,node);
	}

	// addlast method 
	public void addlast(int x) {
		IntNode temp = this.node;
		while (temp.tail != null) {
			temp = temp.tail;
		}
		temp.tail = new IntNode(x, null);
	}

	// getfirst method
	public int getfirst() {
		return this.node.head;
	}

	// getlast method
	public int getlast(){
		IntNode temp = this.node;
		while(temp.tail != null) {
			temp = temp.tail;
		}
		return temp.head;
	}

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

	//test
	public static void main(String[] args) {
		SLList P = new SLList(10);
		P.addfirst(20);
		P.addfirst(30);
		P.addlast(15); //30,20,10,15
		System.out.println(P.getfirst());  
		System.out.println(P.getlast());
		System.out.println(P.recursivesize());
	}
}