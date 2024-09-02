class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;

        // Calculate the total sum of chalk required in one iteration
        long totalChalkSum = 0;
        for (int chalkReq : chalk) {
            totalChalkSum += chalkReq;
        }

        // Calculate the remaining chalk after full iterations
        int remainChalk = (int)(k % totalChalkSum);

        // Find the first student who cannot complete their required chalk usage
        for (int i = 0; i < n; i++) {
            if (remainChalk < chalk[i]) {
                return i;
            }
            remainChalk -= chalk[i];
        }

        return -1; // In theory, this line should never be reached
    }
}