public class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceWins = 0;
        int bobWins = 0;
        
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A') {
                aliceWins++;
            } else if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B') {
                bobWins++;
            }
        }
        
        return aliceWins > bobWins;
    }
}
