public class Corgi extends Dog{
	public void bark(Corgi c) {
		System.out.println("Method B was invoked");
	}

	@Override
	public void bark(Dog d) {
		System.out.println("Method C was invoked");
	}


	public void play(Dog d) {
		System.out.println("Method D was invoked");
	}

	public void play(Corgi c) {
		System.out.println("Method E was invoked");
	}


	public static void main(String[] args) {
		Dog d = new Corgi();
		Corgi c = new Corgi();
		//static type of d is dog
		//static type of c is Corgi
		d.bark(d);
		d.bark(c);// even the c is  Corgi, the override method was still called?
	}
}


