/** 其实你可以把static variable 想象成一个类的总特种，这个总特征不随这instance variable的变化而变化 */

public class Cat {
   public String name;
   // static variable will not changed by the instance. It will change by the class.
   public static String noise;
   
   public Cat(String name, String noise) {
      this.name = name;
      this.noise = noise;
   }
   public void play() {
      System.out.println(noise + " I’m " + name + " the cat!");
   }
   public static void anger() { 
      noise = noise.toUpperCase();
   }
   public static void calm() {
      noise = noise.toLowerCase();
   }
   public static void main(String[] args) {
      Cat a = new Cat("Cream", "Meow!");   // static variable noise: Meow
      Cat b = new Cat("Tubbs", "Nyan!");   // static variable noise: Nyan
      a.play();                            // Nyan
      b.play();                            // Nyan
      Cat.anger();                         // static variable noise: NYAN
      a.calm();                            // Even you can use instance a to call the static function, it will change the static variable Noise for entire class.
      a.play();                            // nyan
      b.play();                            // nyan 
   }
}