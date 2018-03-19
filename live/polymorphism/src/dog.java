import java.util.Comparator;

public class dog implements Comparable<dog> {
    public int size;
    public String name;

    public dog(int size, String name) {
        this.size = size;
        this.name = name;
    }


    public int compareTo(dog o){
        return this.size - o.size;
    }

    public static NameComparator getComparator(){
        return new NameComparator();
    }

    private static class NameComparator implements Comparator<dog> {
        public int compare(dog a, dog b) {
            return a.name.compareTo(b.name);
        }
    }
}
