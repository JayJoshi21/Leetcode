class Solution(object):
    def maxScoreSightseeingPair(self, values):
        """
        :type values: List[int]
        :rtype: int
        """
        max_score = 0
        max_value_plus_i = values[0] + 0
        
        for j in range(1, len(values)):
            # Update max_score with the current pair
            max_score = max(max_score, max_value_plus_i + values[j] - j)
            # Update max_value_plus_i for the next iteration
            max_value_plus_i = max(max_value_plus_i, values[j] + j)
        
        return max_score
  