class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        if k == 0:
            return [0] * n  # All elements are replaced with 0 when k == 0
        
        result = [0] * n  # Initialize the result array
        
        for i in range(n):
            if k > 0:
                # Sum of the next k elements (circular)
                result[i] = sum(code[(i + j) % n] for j in range(1, k + 1))
            else:
                # Sum of the previous k elements (circular, reverse direction)
                result[i] = sum(code[(i + j) % n] for j in range(k, 0))
        
        return result
