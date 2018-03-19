import java.util.Comparator;

public class max {
   public static Comparable findMax(Comparable[] array){
       int maxIndex = 0;
       for(int i = 0; i < array.length; i++) {
           int cmp = array[i].compareTo(array[maxIndex]);
           if(cmp > 0) {
               maxIndex = i;
           }
       }
       return array[maxIndex];
   }

    public static void main(String[] args) {
        dog a = new dog(5, "Chanel");
        dog b = new dog(10, "BoBo");
        dog [] dogArray = {a, b};
        dog result = (dog)findMax(dogArray);
        System.out.println(result.size);

        Comparator nc = dog.getComparator();
        System.out.println(nc.compare(a,b));

    }
}
