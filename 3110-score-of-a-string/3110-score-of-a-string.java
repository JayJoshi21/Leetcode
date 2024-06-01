class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return score;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scoreOfString("hello")); 
        System.out.println(solution.scoreOfString("abc"));    
        System.out.println(solution.scoreOfString("abcdef")); 
    }
}
