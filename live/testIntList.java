public class testIntList {
	public static void main (String[] args) {
		IntList P = new IntList (3, null);
		P = new IntList(10, P);
		P = new IntList(29, P);
		P = new IntList(34, P);
		P = new IntList(31, P);
		P = new IntList(32, P);
		P = new IntList(35, P);
		P = new IntList(36, P);
		System.out.println(P.size1());
		System.out.println(P.size2());
		System.out.println(P.get1(5));
		System.out.println(P.get2(5));
	}

}	
