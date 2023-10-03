class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Initialize a hash table to store the count of each unique element.
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Iterate through the array and count the occurrences of each element.
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int goodPairs = 0;
        
        // Iterate through the countMap to calculate the number of good pairs.
        for (int count : countMap.values()) {
            // Calculate the number of good pairs for each element using (count * (count - 1)) / 2 formula.
            goodPairs += (count * (count - 1)) / 2;
        }
        
        return goodPairs;
    }
}
