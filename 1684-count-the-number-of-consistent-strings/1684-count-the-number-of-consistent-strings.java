class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;

        // Create mask
        for (char ch : allowed.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }

        int count = 0;

        // Iterate over words
        for (String word : words) {
            boolean allCharAllowed = true;

            // Check each character in the word
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                // Check if the bit corresponding to this character is set in the mask
                if (((mask >> (ch - 'a')) & 1) == 0) {
                    allCharAllowed = false;
                    break;
                }
            }

            if (allCharAllowed) {
                count++;
            }
        }

        return count;
    }
}