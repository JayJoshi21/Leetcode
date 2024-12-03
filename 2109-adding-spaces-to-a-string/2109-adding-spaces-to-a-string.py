class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        result = []  # Use a list to efficiently build the result
        space_idx = 0  # Pointer for the `spaces` list
        n = len(spaces)  # Length of the `spaces` list

        for i, char in enumerate(s):
            # If the current index matches the space index, add a space
            if space_idx < n and i == spaces[space_idx]:
                result.append(" ")
                space_idx += 1
            # Append the current character
            result.append(char)

        # Join the result list to form the final string
        return "".join(result)
