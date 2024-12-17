import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Step 1: Count frequencies of characters
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Use a max-heap (priority queue) to store characters and their counts
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // Store character index and its frequency
            }
        }

        StringBuilder result = new StringBuilder();

        // Step 3: Build the result string
        while (!maxHeap.isEmpty()) {
            int[] largest = maxHeap.poll(); // The largest character
            int charIndex = largest[0], count = largest[1];

            // Determine how many times we can use this character
            int useCount = Math.min(count, repeatLimit);
            
            // Append the character `useCount` times to the result
            for (int i = 0; i < useCount; i++) {
                result.append((char) (charIndex + 'a'));
            }

            // If we used up all occurrences of the character, skip reinsertion
            if (count > useCount) {
                // Need to "pause" this character and use the next one
                if (!maxHeap.isEmpty()) {
                    int[] secondLargest = maxHeap.poll(); // Second largest character
                    result.append((char) (secondLargest[0] + 'a')); // Append second largest once
                    secondLargest[1]--;

                    // Reinsert the second largest character if it still has occurrences
                    if (secondLargest[1] > 0) {
                        maxHeap.offer(secondLargest);
                    }

                    // Reinsert the largest character back to the heap
                    largest[1] -= useCount;
                    maxHeap.offer(largest);
                } else {
                    // No more characters to break the sequence, stop the process
                    break;
                }
            }
        }

        return result.toString();
    }
}
