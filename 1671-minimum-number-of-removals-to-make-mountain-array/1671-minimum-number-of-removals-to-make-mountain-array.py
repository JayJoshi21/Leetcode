class Solution(object):
    def minimumMountainRemovals(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        
        # Step 1: Compute LIS from the left
        left_lis = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]:
                    left_lis[i] = max(left_lis[i], left_lis[j] + 1)

        # Step 2: Compute LIS from the right
        right_lis = [1] * n
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                if nums[j] < nums[i]:
                    right_lis[i] = max(right_lis[i], right_lis[j] + 1)

        # Step 3: Calculate the minimum number of removals needed
        max_mountain_len = 0
        for i in range(1, n - 1):
            if left_lis[i] > 1 and right_lis[i] > 1:
                max_mountain_len = max(max_mountain_len, left_lis[i] + right_lis[i] - 1)
        
        return n - max_mountain_len
