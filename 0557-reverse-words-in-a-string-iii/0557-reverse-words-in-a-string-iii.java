public class Solution {
    public String reverseWords(String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // Create a StringBuilder to store the reversed result
        StringBuilder reversedString = new StringBuilder();

        // Iterate through the words
        for (String word : words) {
            // Reverse each word and append it to the StringBuilder
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversedString.append(reversedWord).append(" "); // Append a space after each reversed word
        }

        // Remove the trailing space and convert the StringBuilder to a String
        return reversedString.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String inputString = "Let's take LeetCode contest";
        String reversedResult = solution.reverseWords(inputString);
        System.out.println(reversedResult); // Output: "s'teL ekat edoCteeL tsetnoc"
    }
}
