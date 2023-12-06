public class Solution {
    public int totalMoney(int n) {
        int result = 0;
        
        int mondayMoney = 1;
        
        while (n > 0) {
            int money = mondayMoney;
            for (int day = 1; day <= Math.min(n, 7); day++) {
                result += money++;
            }
            
            n -= 7;
            mondayMoney += 1;
        }
        
        return result;
    }
}
