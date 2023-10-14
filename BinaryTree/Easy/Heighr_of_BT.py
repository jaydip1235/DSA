#GeeksforGeeks problem
#User function Template for python3

'''
# Node Class:
class Node:
    def _init_(self,val):
        self.data = val
        self.left = None
        self.right = None
        '''
class Solution:
    def getHeight(self,node):
        if node==None:
            return 0
        # if node.left==None and node.right==None:
        #     return 0
        left=self.getHeight(node.left)
        right=self.getHeight(node.right)
        return max(left,right)+1
    #Function to find the height of a binary tree.
    def height(self, root):
        # code here
        if root==None:
            return 0
        height= self.getHeight(root)
        return height



