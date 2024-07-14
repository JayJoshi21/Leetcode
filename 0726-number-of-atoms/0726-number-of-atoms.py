from collections import defaultdict
import re

class Solution(object):
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """
        def parse():
            n = len(formula)
            stack = [defaultdict(int)]
            i = 0
            
            while i < n:
                if formula[i] == '(':
                    stack.append(defaultdict(int))
                    i += 1
                elif formula[i] == ')':
                    i += 1
                    i_start = i
                    while i < n and formula[i].isdigit():
                        i += 1
                    multiplier = int(formula[i_start:i] or 1)
                    top = stack.pop()
                    for element, count in top.items():
                        stack[-1][element] += count * multiplier
                else:
                    i_start = i
                    i += 1
                    while i < n and formula[i].islower():
                        i += 1
                    element = formula[i_start:i]
                    i_start = i
                    while i < n and formula[i].isdigit():
                        i += 1
                    count = int(formula[i_start:i] or 1)
                    stack[-1][element] += count
            
            return stack[0]
        
        element_counts = parse()
        sorted_elements = sorted(element_counts.items())
        result = []
        
        for element, count in sorted_elements:
            result.append(element)
            if count > 1:
                result.append(str(count))
        
        return ''.join(result)

# Example usage
solution = Solution()
formula = "H2O"
output = solution.countOfAtoms(formula)
print(output)  # Output should be "H2O"
