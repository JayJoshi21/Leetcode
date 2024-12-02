class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        # Split the sentence into words
        words = sentence.split()
        
        # Iterate through words with their indices
        for i, word in enumerate(words):
            # Check if the word starts with searchWord
            if word.startswith(searchWord):
                return i + 1  # Return 1-based index
        
        # If no word matches, return -1
        return -1