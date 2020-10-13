"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 07. 重建二叉树
https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if len(preorder)==0:
            return None

        return find_root(preorder, (0, len(preorder)), inorder, (0, len(inorder)))

def find_root(preorder, p_meta, inorder, i_meta):
    """
        :type preorder: List[int]
        :type p_meta: (beginidx, length)
        :type inorder: List[int]
        :type i_meta: (beginidx, length)
    """

    #print p_meta, i_meta

    root_value = preorder[p_meta[0]]

    #print "root is ", root_value

    root = TreeNode()
    root.val= root_value

    # search in inorder
    left_len = 0
    right_len = 0
    in_idx = 0
    for i in range(i_meta[1]):
        if inorder[i_meta[0]+i]== root_value:
            in_idx = i_meta[0]+i
            #print "find root: ", in_idx
            left_len = i
            right_len = i_meta[1] - i - 1

    if left_len > 0:
        #print "to left", p_meta[0]+1, left_len, i_meta[0], left_len
        root.left = find_root(
                            preorder, (p_meta[0]+1, left_len), 
                            inorder, (i_meta[0], left_len)
                            )

    if right_len > 0:
        #print "to right", p_meta[0+1]+left_len, right_len, inorder, (in_idx+1, right_len)
        root.right = find_root(
                            preorder, (p_meta[0]+1+left_len, right_len), 
                            inorder, (in_idx+1, right_len)
                            )

    return root

