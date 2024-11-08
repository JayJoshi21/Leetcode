class Solution(object):
    def getMaximumXor(self, nums, maximumBit):
        """
        :type nums: List[int]
        :type maximumBit: int
        :rtype: List[int]
        """
        # Calculate the maximum possible value with maximumBit bits
        max_val = (1 << maximumBit) - 1
        
        # Calculate the XOR of all elements in nums
        xor_total = 0
        for num in nums:
            xor_total ^= num
        
        # Prepare the answer list
        answer = []
        
        # Process each query by removing the last element of nums
        for i in range(len(nums) - 1, -1, -1):
            # Calculate the k that maximizes xor_total ^ k
            k = xor_total ^ max_val
            answer.append(k)
            
            # Update xor_total by removing the last element
            xor_total ^= nums[i]
        
        return answer
