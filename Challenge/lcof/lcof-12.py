"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 12. 矩阵中的路径
https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
"""
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        res = False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if search_dfs(board, i, j, word, 0):
                    return True
        
        return res

def search_dfs(board, i, j, word, k):
    if i<0 or i>=len(board) or j<0 or j>=len(board[0]) or board[i][j]<>word[k]:
        return False
    
    if k+1==len(word):
        return True
    
    tmp = board[i][j]
    board[i][j] = '/'
    
    res = search_dfs(board, i, j+1, word, k+1) or search_dfs(board, i+1, j, word, k+1) or search_dfs(board, i-1, j, word, k+1) or search_dfs(board, i, j-1, word, k+1)

    board[i][j] = tmp
    return res
