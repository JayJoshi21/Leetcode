class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        ans = []
        best = 0

        for x in range(1,n+1):
            if x in target:
                ans.append("Push")
                best = max(len(ans), best)
            else:
                ans.append("Push")
                ans.append("Pop")

        return ans[:best]
        