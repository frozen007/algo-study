"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 14- I. 剪绳子
https://leetcode-cn.com/problems/jian-sheng-zi-lcof/

# tag(dp)
"""

class Solution(object):
    def cuttingRope(self, n):
        """
        :type n: int
        :rtype: int
        """

        f = [0 for i in range(n+1)]

        f[0] = 0
        f[1] = 0

        for i in range(2, n+1):
            c = 0
            for j in range(1,i):
                if j * (i - j) > c:
                    c = j * (i - j)
                
                if f[i-j] * j > c:
                    c = f[i-j] * j

            f[i] = c

        for i in range(1,n+1):
            print "f[%d]=%d" %(i, f[i])
        return f[n]
