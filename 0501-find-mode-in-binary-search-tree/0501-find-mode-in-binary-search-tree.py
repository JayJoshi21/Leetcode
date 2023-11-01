# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        if not root.left and not root.right:
            return [root.val]
        def checkDups(root) :
            if root.val not in count:
                count[root.val] =1
            else:
                count[root.val] +=1
            if not root.left and not root.right :
                return
            if root.left:
                checkDups(root.left)
            if root.right :
                checkDups(root.right)
        count={}
        checkDups(root)
        result=[]
        maximum_count = max(count.values())
        for key,value in count.items() :
            if value==maximum_count:
                result.append(key)
        return result           
                    
        