'''
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 15. 二进制中1的个数
https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
'''
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        d = n
        while d>0:
            count = count + (d&1)
            d = d>>1
            print d, count
        
        return count