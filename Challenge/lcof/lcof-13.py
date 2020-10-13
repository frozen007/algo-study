"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 13. 机器人的运动范围
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
"""

class Solution(object):
    def movingCount(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """
        a = [[0 for i in range(n)] for j in range(m)]
        return move(0, 0, m, n, k, a)

def move(i, j, m, n, k, a):

    if i<0 or i>=m or j<0 or j>=n:
        return 0

    if a[i][j]==1:
        return 0
    
    a[i][j]=1
    
    test = i/10 + i%10 + j/10 + j%10
    if test > k:
        return 0
    
    return 1 + move(i+1, j, m, n, k, a) + move(i, j+1, m, n, k, a)
