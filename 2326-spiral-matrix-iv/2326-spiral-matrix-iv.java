class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        
        // Initialize the matrix with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        int id = 0; // Direction identifier (0: left->right, 1: top->down, 2: right->left, 3: down->top)

        while (top <= down && left <= right && head != null) {
            if (id == 0) { // left to right
                for (int i = left; i <= right && head != null; i++) {
                    matrix[top][i] = head.val;
                    head = head.next;
                }
                top++;
            } 
            else if (id == 1) { // top to down
                for (int i = top; i <= down && head != null; i++) {
                    matrix[i][right] = head.val;
                    head = head.next;
                }
                right--;
            } 
            else if (id == 2) { // right to left
                for (int i = right; i >= left && head != null; i--) {
                    matrix[down][i] = head.val;
                    head = head.next;
                }
                down--;
            } 
            else if (id == 3) { // down to top
                for (int i = down; i >= top && head != null; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }

            id = (id + 1) % 4; // Cycle through directions
        }

        return matrix;
    }
}