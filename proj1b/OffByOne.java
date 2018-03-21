public class OffByOne implements CharacterComparator {
    @Override
    //such that equalChars returns true for characters that are different by exactly one.
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return (Math.abs(diff) == 1);
    }
}
