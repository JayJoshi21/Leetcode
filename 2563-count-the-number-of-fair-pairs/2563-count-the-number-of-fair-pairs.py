from typing import List
import bisect

class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        # Sort the nums array for efficient pair finding
        nums.sort()
        n = len(nums)
        count = 0
        
        # For each element nums[i], find pairs that satisfy the range condition
        for i in range(n - 1):
            # Define the range of valid values for nums[j] with j > i
            min_val = lower - nums[i]
            max_val = upper - nums[i]
            
            # Use binary search to find the range in the sorted list
            left = bisect.bisect_left(nums, min_val, i + 1, n)  # First index where nums[j] >= min_val
            right = bisect.bisect_right(nums, max_val, i + 1, n)  # First index where nums[j] > max_val
            
            # Add the count of valid pairs (i, j) for the current i
            count += (right - left)
        
        return count
