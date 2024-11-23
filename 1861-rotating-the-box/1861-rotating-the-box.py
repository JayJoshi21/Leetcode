class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        m, n = len(box), len(box[0])

        # Simulate gravity for each row
        for row in box:
            empty = n - 1  # Start at the rightmost column
            for col in range(n - 1, -1, -1):
                if row[col] == '#':  # If it's a stone
                    row[col], row[empty] = row[empty], row[col]  # Move stone to the `empty` position
                    empty -= 1
                elif row[col] == '*':  # If it's an obstacle
                    empty = col - 1  # Reset the `empty` position

        # Rotate the box 90 degrees clockwise
        rotated = [[None] * m for _ in range(n)]  # Create an empty matrix for the rotated box
        for i in range(m):
            for j in range(n):
                rotated[j][m - 1 - i] = box[i][j]  # Transpose and reverse rows

        return rotated
    