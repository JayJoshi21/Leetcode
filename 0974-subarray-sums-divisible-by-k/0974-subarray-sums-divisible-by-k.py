from typing import List
from collections import defaultdict

class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        # HashMap to store the count of prefix sum remainders
        remainder_count = defaultdict(int)
        
        # Initial condition: a remainder of 0 is encountered once at the beginning
        remainder_count[0] = 1
        
        prefix_sum = 0
        result = 0
        
        for num in nums:
            # Update the prefix sum
            prefix_sum += num
            
            # Calculate the remainder of the current prefix sum when divided by k
            remainder = prefix_sum % k
            
            # Python's mod operator can return negative results, convert them to positive
            if remainder < 0:
                remainder += k
            
            # If this remainder has been seen before, it means there are subarrays
            # which end at the current index and are divisible by k
            if remainder in remainder_count:
                result += remainder_count[remainder]
            
            # Update the count of the current remainder in the hashmap
            remainder_count[remainder] += 1
        
        return result

# Example usage
nums = [4, 5, 0, -2, -3, 1]
k = 5
solution = Solution()
print(solution.subarraysDivByK(nums, k))  # Output: 7
