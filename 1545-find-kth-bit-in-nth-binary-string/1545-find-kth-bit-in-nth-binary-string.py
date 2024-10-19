class Solution(object):
    def findKthBit(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        def helper(n, k):
            # Base case: S1 is "0"
            if n == 1:
                return "0"
            
            # Calculate the middle index of Sn
            mid = 2 ** (n - 1)
            
            if k == mid:
                return "1"
            elif k < mid:
                return helper(n - 1, k)
            else:
                # Find the corresponding index in the left half and invert it
                return '1' if helper(n - 1, 2 * mid - k) == '0' else '0'
        
        # Call the helper function to find the kth bit
        return helper(n, k)

# Example usage:
solution = Solution()
print(solution.findKthBit(3, 1))  # Output: "0"
print(solution.findKthBit(4, 11))  # Output: "1"
