# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        stack = []
        result = []
        prev = None

        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            else:
                peek_node = stack[-1]
                # If right child exists and it hasn't been visited yet
                if peek_node.right and peek_node.right != prev:
                    root = peek_node.right
                else:
                    # Visit the node
                    result.append(peek_node.val)
                    prev = stack.pop()
                    root = None  # Continue with stack processing

        return result
