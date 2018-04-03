package objectMethods;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    @Override
    public boolean equals(Object o){
        // if two objects have the same reference (memory address), it should return true.
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        Date that = (Date) o;
        if(this.month != that.month || this.day != that.day || this.year != that.year) {
            return false;
        }
        return true;
    }

}