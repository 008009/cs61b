public class IntList {
	public static void main (String[] args) {
		IntList P = new IntList (3, null);
		P = new IntList(10, P);
		P = new IntList(29, P);
		System.out.println(P.head);
	}	
}	
