class Solution(object):
    def permute(self, nums):
        def backtrack(first=0):
            if first == len(nums):
                output.append(nums[:])
                return
            for i in range(first, len(nums)):
                nums[first], nums[i] = nums[i], nums[first]
                backtrack(first + 1)
                nums[first], nums[i] = nums[i], nums[first]
        
        output = []
        backtrack()
        return output


