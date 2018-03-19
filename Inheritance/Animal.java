public class Animal{
	protected String name, noise;
	protected int age;

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		this.noise = "Huh";
	}

	public String makeNoise(){
		if(age < 5) {
			return noise.toUpperCase();
		}
		else{
			return noise;
		}
	}

	public void greet(){
		System.out.println("Animal " + name + " says: " + makeNoise());
	}
}

/**
Given the Animal class, fill in the definition of the Cat class so that when greet() is called, 
the label “Cat” (instead of “Animal”) is printed to the screen. 
Assume that a Cat will make a “Meow!” noise if the cat is 5 years or older and “MEOW!” if the cat is less than 5 years old.
*/

public class Cat extends Animal {
	public String name, noise;
	public int age;

	public Cat(String name, int age){
		this.name = name;
		this.age = age;
		this.noise = “Meow”;
	}

	@override
	public String makeNose(){
		if(age < 5) {
			return noise.toUpperCase();
		}
		else{
			return noise;
		}
	}

	@override
	public void greet(){
		System.out.println("Cat" + name + "says" + makeNoise());
	}

	public static void main(String[] args) {
		Animal a = new Animal("Pluto", 10);
		Cat c = new Cat("Garfield", 6);
		System.out.println(a.greet());   // Animal Pluto HUH
		System.out.println(c.greet());   // Cat Garfield MEOW
	} 
}


