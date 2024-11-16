from typing import List

class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = []
        
        for i in range(n - k + 1):
            subarray = nums[i:i + k]
            
            # Check if the subarray is consecutive and sorted
            is_consecutive_and_sorted = True
            for j in range(1, k):
                if subarray[j] != subarray[j - 1] + 1:
                    is_consecutive_and_sorted = False
                    break
            
            # If the subarray is valid, add its maximum value; otherwise, add -1
            if is_consecutive_and_sorted:
                result.append(max(subarray))
            else:
                result.append(-1)
        
        return result
