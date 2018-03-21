/*
Given a String, wordToDeque should return a Deque where the characters appear in the same order as in the String.
For example, if the word is “persiflage”,
then the returned Deque should have ‘p’ at the front, followed by ‘e’, and so forth.
*/
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque();
        for(int i = word.length() - 1; i >= 0; i--){
            Character letter = word.charAt(i);
            result.addFirst(letter);
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        if(word == null) {
            throw new java.lang.IllegalArgumentException("The string should not be null");
        }
        if(word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> result = wordToDeque(word);
        while(result.size() > 1) {
            if(result.removeFirst() == result.removeLast()){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if(word == null) {
            throw new java.lang.IllegalArgumentException("The string should not be null");
        }
        if(word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> result = wordToDeque(word);
        while(result.size() > 1) {
            if(cc.equalChars(result.removeFirst(), result.removeLast())) {
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

}
