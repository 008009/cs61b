/*Find the k most common words in a document.
    Assume that you can represent this as an array of Strings, where each word is an element in the array.
    You might find using multiple data structures useful.

 */
import java.util.Map;
import java.util.HashMap;

public class wordFreq {
    Map<String, Integer> map = new HashMap<String, Integer>();

    public void wordFrequence(String[] arr) {
        for(String word : arr) {
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }
            else{
                map.put(word, map.get(word) + 1);
            }
        }
    }

}
