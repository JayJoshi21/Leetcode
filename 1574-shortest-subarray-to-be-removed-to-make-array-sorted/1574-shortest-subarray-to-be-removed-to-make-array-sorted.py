class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n = len(arr)
        
        # Step 1: Find the longest non-decreasing prefix
        left = 0
        while left < n - 1 and arr[left] <= arr[left + 1]:
            left += 1
        
        # If the entire array is already sorted
        if left == n - 1:
            return 0
        
        # Step 2: Find the longest non-decreasing suffix
        right = n - 1
        while right > 0 and arr[right - 1] <= arr[right]:
            right -= 1
        
        # Step 3: Calculate initial answer as removing all elements between left and right
        min_length = min(n - left - 1, right)  # Remove prefix or suffix entirely
        
        # Step 4: Merge prefix and suffix using two pointers
        i, j = 0, right
        while i <= left and j < n:
            if arr[i] <= arr[j]:
                min_length = min(min_length, j - i - 1)
                i += 1
            else:
                j += 1
        
        return min_length
