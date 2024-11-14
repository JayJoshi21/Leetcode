from typing import List

class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        # Binary search for the smallest possible maximum number of products per store
        left, right = 1, max(quantities)
        
        def canDistribute(max_per_store: int) -> bool:
            # Check if we can distribute all products with max_per_store being the maximum per store
            required_stores = 0
            for q in quantities:
                # Calculate how many stores are needed for this quantity with max_per_store limit
                required_stores += (q + max_per_store - 1) // max_per_store  # Equivalent to ceil(q / max_per_store)
            return required_stores <= n
        
        # Perform binary search to find the minimum feasible maximum per store
        while left < right:
            mid = (left + right) // 2
            if canDistribute(mid):
                right = mid  # Try for a smaller max by adjusting the upper bound
            else:
                left = mid + 1  # Increase the lower bound to find a feasible max
        
        return left
  