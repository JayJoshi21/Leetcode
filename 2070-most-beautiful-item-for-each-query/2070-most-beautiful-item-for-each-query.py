from typing import List

class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        # Step 1: Sort items by price, then by beauty in descending order for equal prices
        items.sort()
        
        # Step 2: Create a list to store maximum beauty up to each price
        max_beauty_by_price = []
        max_beauty_so_far = 0
        
        for price, beauty in items:
            # Only store the maximum beauty so far at each unique price
            max_beauty_so_far = max(max_beauty_so_far, beauty)
            # Append (price, max_beauty_so_far) to track maximum beauty up to this price
            max_beauty_by_price.append((price, max_beauty_so_far))
        
        # Step 3: Sort queries and store the original indices
        sorted_queries = sorted((q, i) for i, q in enumerate(queries))
        answer = [0] * len(queries)
        
        # Step 4: Process each query using binary search on max_beauty_by_price
        j = 0
        for query, original_index in sorted_queries:
            # Move pointer until the price exceeds the current query
            while j < len(max_beauty_by_price) and max_beauty_by_price[j][0] <= query:
                j += 1
            
            # If j is 0, no price is <= query, so answer is 0 for this query
            if j > 0:
                answer[original_index] = max_beauty_by_price[j - 1][1]
            else:
                answer[original_index] = 0
        
        return answer
