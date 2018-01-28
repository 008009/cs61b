public class DogLauncher {
	public static void main(String[] args) {

		Dog d = new Dog(15);
		Dog d2 = new Dog(100);
		Dog result = new Dog(16);

		/* using class to call static method */
		Dog Sresult = Dog.maxDog(d, d2);
		Sresult.makeNoise();

		/* using instance to call static method */
		result.makeNoise();   //bark 
		result = result.maxDog(d,d2);
		result.makeNoise();   //wooof

		/* using instance to call instance method*/
		Dog Iresult = d.maxDog2(d2);
		Iresult.makeNoise();
	}
} 