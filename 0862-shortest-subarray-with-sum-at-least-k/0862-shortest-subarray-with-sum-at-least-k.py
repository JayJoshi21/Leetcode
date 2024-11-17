from collections import deque
from typing import List

class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        # Initialize variables
        n = len(nums)
        prefix_sum = [0] * (n + 1)  # To store the prefix sums
        
        # Compute prefix sum
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + nums[i]
        
        dq = deque()  # Deque to store indices
        min_length = float('inf')  # Initialize minimum length to infinity
        
        # Iterate through the prefix sum array
        for i in range(n + 1):
            # Check for valid subarray with sum >= k
            while dq and prefix_sum[i] - prefix_sum[dq[0]] >= k:
                min_length = min(min_length, i - dq.popleft())
            
            # Maintain increasing order of prefix_sum in deque
            while dq and prefix_sum[i] <= prefix_sum[dq[-1]]:
                dq.pop()
            
            # Add current index to deque
            dq.append(i)
        
        # Return the result
        return min_length if min_length != float('inf') else -1
