import java.util.Map;
import java.util.HashMap;

/*
Given an array of integers A and an integer k, return true if any two numbers in the array sum up to k,
and return false otherwise.
*/
public class TwoSum {
    public boolean twoSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(k - arr[i])){
                return true;
            }
            else{
                map.put(arr[i],arr[i]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2,5,7,8,12,4};
        TwoSum test = new TwoSum();
        System.out.println(test.twoSum(arr, 16));
    }
}
