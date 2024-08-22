class Solution {
    public int findComplement(int num) {
        int i = 0, ans = 0;
        while (num != 0) {
            // If the current bit is 0, set the corresponding bit in ans to 1
            if ((num & 1) == 0)
                ans |= (1 << i);
            num >>= 1;
            i++;
        }
        return ans;
    }
}