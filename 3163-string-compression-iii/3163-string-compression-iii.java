class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();  // To store the compressed result
        int i = 0;
        
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;
            
            // Count up to 9 consecutive characters
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }
            
            // Append count and character to the result
            comp.append(count).append(currentChar);
        }
        
        return comp.toString();
    }
}
