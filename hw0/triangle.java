public class triangle {
	public static void drawTriangle(int n){
		int line = 1;
		while(line <= n) {
			for (int i = 0; i < line; i++) {
				System.out.print("*");
			}
			System.out.println();
			line++;
		}
	}
	public static void main(String[] args) {
		drawTriangle(7);
	}
}