class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        p = sorted([x for x, _ in points])
        return max(list(abs(x -y) for x, y in zip(p, p[1:])))
        