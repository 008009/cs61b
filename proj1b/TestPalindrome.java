import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        String word1 = "SpringBreak";
        String word2 = "pppppppppp";
        String word3 = "ab b a";
        String word4 = null;
        boolean R1 = palindrome.isPalindrome(word1);
        boolean R2 = palindrome.isPalindrome(word2);
        boolean R3 = palindrome.isPalindrome(word3);
        //boolean R4 = palindrome.isPalindrome(word4);
        assertFalse(R1);
        assertTrue(R2);
        assertFalse(R3);
    }

    @Test
    public void isPalindrome() {
        CharacterComparator cc = new OffByOne();
        String test1 = "wooooooooooooooooooooooooooow";
        String test2 = "array";
        String test3 = "radar";
        String test4 = "flake";
        String test5 = "oop";
        assertFalse(palindrome.isPalindrome(test1, cc));
        assertFalse(palindrome.isPalindrome(test2, cc));
        assertFalse(palindrome.isPalindrome(test3, cc));
        assertTrue(palindrome.isPalindrome(test4, cc));
        assertTrue(palindrome.isPalindrome(test5, cc));
    }
}
