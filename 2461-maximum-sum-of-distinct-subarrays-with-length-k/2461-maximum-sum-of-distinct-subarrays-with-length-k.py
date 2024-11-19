class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        # Initialize variables
        maxSum = 0
        currentSum = 0
        start = 0
        unique_elements = set()

        for end in range(len(nums)):
            # Add the current number to the window
            while nums[end] in unique_elements:
                # Remove the leftmost element until there are no duplicates
                unique_elements.remove(nums[start])
                currentSum -= nums[start]
                start += 1
            
            # Add the current element to the window
            unique_elements.add(nums[end])
            currentSum += nums[end]

            # If the window size reaches k
            if end - start + 1 == k:
                maxSum = max(maxSum, currentSum)
                # Shrink the window from the left for the next iteration
                unique_elements.remove(nums[start])
                currentSum -= nums[start]
                start += 1

        return maxSum
      