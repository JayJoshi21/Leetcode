class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        # Vowel to bit position mapping
        vowel_to_bit = {'a': 1, 'e': 2, 'i': 4, 'o': 8, 'u': 16}
        
        # Dictionary to store the first occurrence of each bitmask
        mask_to_index = {0: -1}
        
        # Initial values
        current_mask = 0
        max_length = 0
        
        # Traverse through the string
        for i, char in enumerate(s):
            # Update the bitmask if the character is a vowel
            if char in vowel_to_bit:
                current_mask ^= vowel_to_bit[char]
            
            # If this mask has been seen before, calculate the length of the substring
            if current_mask in mask_to_index:
                max_length = max(max_length, i - mask_to_index[current_mask])
            else:
                # Store the first occurrence of this mask
                mask_to_index[current_mask] = i
        
        return max_length
       