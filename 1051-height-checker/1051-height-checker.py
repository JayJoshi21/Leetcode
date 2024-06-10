from typing import List

class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        # Create a sorted version of the heights list
        expected = sorted(heights)
        
        # Count how many indices have different values between the original and the sorted list
        mismatch_count = 0
        for original, sorted_val in zip(heights, expected):
            if original != sorted_val:
                mismatch_count += 1
        
        return mismatch_count

# Example usage
heights = [1, 1, 4, 2, 1, 3]
solution = Solution()
print(solution.heightChecker(heights))  # Output: 3
      