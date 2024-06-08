from typing import List

class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        remainder_map = {0: -1}  # To handle edge case when subarray starts from index 0
        cumulative_sum = 0
        
        for i, num in enumerate(nums):
            cumulative_sum += num
            remainder = cumulative_sum % k if k != 0 else cumulative_sum
            
            if remainder in remainder_map:
                if i - remainder_map[remainder] > 1:
                    return True
            else:
                remainder_map[remainder] = i
                
        return False

# Example usage:
nums = [23, 2, 6, 4, 7]
k = 13
solution = Solution()
print(solution.checkSubarraySum(nums, k))  # Output: False
