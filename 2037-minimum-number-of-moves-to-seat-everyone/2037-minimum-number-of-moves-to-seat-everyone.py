from typing import List

class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        # Step 1: Sort both the lists
        seats.sort()
        students.sort()
        
        # Step 2: Initialize the total number of moves
        total_moves = 0
        
        # Step 3: Calculate the moves for each pair
        for seat, student in zip(seats, students):
            total_moves += abs(seat - student)
        
        # Step 4: Return the total number of moves
        return total_moves

# Example usage
solution = Solution()
seats = [2, 2, 6, 6]
students = [1, 3, 2, 6]
print(solution.minMovesToSeat(seats, students))  # Output: 4
