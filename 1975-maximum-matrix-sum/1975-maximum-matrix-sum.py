from typing import List

class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total_sum = 0
        min_abs_value = float('inf')  # To track the smallest absolute value in the matrix
        negative_count = 0  # To count the number of negative elements

        # Traverse the matrix
        for row in matrix:
            for value in row:
                total_sum += abs(value)  # Add the absolute value to the total sum
                min_abs_value = min(min_abs_value, abs(value))  # Track the smallest absolute value
                if value < 0:
                    negative_count += 1  # Count the negative numbers

        # If the number of negative elements is odd, subtract twice the smallest absolute value
        if negative_count % 2 == 1:
            total_sum -= 2 * min_abs_value

        return total_sum
