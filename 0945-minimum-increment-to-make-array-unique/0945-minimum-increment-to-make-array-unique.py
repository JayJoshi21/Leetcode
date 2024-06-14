from typing import List

class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        nums.sort()
        moves = 0
        
        for i in range(1, len(nums)):
            if nums[i] <= nums[i - 1]:
                needed_increment = nums[i - 1] + 1 - nums[i]
                nums[i] += needed_increment
                moves += needed_increment
        
        return moves

# Test the function with the given input
solution = Solution()
nums = [1, 2, 2]
print(solution.minIncrementForUnique(nums))  # Output: 1
  