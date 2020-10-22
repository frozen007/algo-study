"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 16. 数值的整数次方
https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
"""

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n==0:
            return 1
            
        t= powx(x, abs(n))
        if n<0:
            t = 1/t

        return t

def powx(x,n):
    if n==1:
        return x

    if n==2:
        return x*x
    
    t = 0
    if n%2==0:
        t = powx(x, n/2)
        t = t*t
    else:
        t = powx(x, (n-1)/2)
        t = t*t*x
    
    return t