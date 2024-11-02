class Solution(object):
    def isCircularSentence(self, sentence):
        """
        :type sentence: str
        :rtype: bool
        """
        # Split the sentence into words
        words = sentence.split()
        
        # Iterate over each word and check the circular condition
        for i in range(len(words)):
            # Get the last character of the current word and the first character of the next word
            current_word_last = words[i][-1]
            next_word_first = words[(i + 1) % len(words)][0]
            
            # Check if they are equal
            if current_word_last != next_word_first:
                return False
        
        # If all conditions are satisfied, the sentence is circular
        return True
