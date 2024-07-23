import java.util.*;

public class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Convert the map to a list of entries
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        
        // Step 3: Sort the entries by frequency (ascending) and value (descending)
        entryList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey(); // Descending order for values
            } else {
                return a.getValue() - b.getValue(); // Ascending order for frequencies
            }
        });
        
        // Step 4: Build the result array
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                resultList.add(num);
            }
        }
        
        // Convert the result list to an array
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
