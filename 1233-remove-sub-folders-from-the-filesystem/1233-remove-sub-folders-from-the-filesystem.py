from typing import List

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        # Step 1: Sort the folders lexicographically
        folder.sort()
        
        # Step 2: Initialize the result list
        result = []
        
        # Step 3: Iterate through the sorted folders
        for f in folder:
            # If the result list is empty or the current folder is not a sub-folder
            # of the last folder in the result list, add it to the result list.
            if not result or not f.startswith(result[-1] + '/'):
                result.append(f)
        
        return result
