class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        n, m = len(str1), len(str2)
        i, j = 0, 0  # Pointers for str1 and str2

        while i < n and j < m:
            # Check if str1[i] can be transformed into str2[j]
            if str1[i] == str2[j] or (ord(str1[i]) - ord('a') + 1) % 26 + ord('a') == ord(str2[j]):
                j += 1  # Move to the next character in str2 if there's a match
            i += 1  # Always move to the next character in str1

        # If we've matched all characters in str2, return True
        return j == m
