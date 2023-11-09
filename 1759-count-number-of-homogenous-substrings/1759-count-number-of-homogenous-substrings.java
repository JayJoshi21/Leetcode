class Solution {
    public static final int MOD = 1000000007;
    
    public int countHomogenous(String s) {
        int n = s.length();
        int result = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            
            result = (result + count) % MOD;
        }
        
        return result;
    }
}