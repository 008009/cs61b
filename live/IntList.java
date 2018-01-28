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
}
