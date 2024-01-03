class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        prev = bank[0].count("1")
        res = 0

        for i in range(1, len(bank)):
            curr = bank[i].count("1")
            res += (prev * curr)
            if curr:

                prev = curr

        return res
        