"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 04. 二维数组中的查找
https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
"""
class Solution(object):
    def findNumberIn2DArray(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        n = len(matrix)
        
        if n==0:
            return False
        
        m = len(matrix[0])

        if m==0:
            return False

        mm = [[0 for i in range(m)] for j in range(n)]

        return search(matrix, target, n, m, 0, 0, mm)

def search(matrix, target, n, m, idx_n, idx_m, mm):

    #print 'invoke search:', idx_n, idx_m, matrix[idx_n][idx_m], mm[idx_n][idx_m]
    
    mm[idx_n][idx_m] = 1

    if matrix[idx_n][idx_m]==target:
        return True

    if matrix[idx_n][idx_m]>target:
        return False 


    if idx_n+1<=n-1 and mm[idx_n+1][idx_m]==0:
        #print idx_n, idx_m, 'a'
        if search(matrix, target, n, m, idx_n+1, idx_m, mm):
            return True

    if idx_m+1<=m-1 and mm[idx_n][idx_m+1]==0:
        #print idx_n, idx_m, 'b'
        if search(matrix, target, n, m, idx_n, idx_m+1, mm):
            return True

    return False