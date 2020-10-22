"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 10- I. 斐波那契数列
https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

# tag(dp)
"""
class Solution(object):
    def fib(self, n):
        """
        :type n: int
        :rtype: int
        """
        buf = [0 for i in range(n+1)]
        return calc_fib(n, buf) % 1000000007
    
def calc_fib(n, buf):
    if buf[n]>0:
        return buf[n]

    fib = 0
    if n==0:
        fib = 0
    elif n==1:
        fib = 1
    else:
        fib = calc_fib(n-1, buf) + calc_fib(n-2, buf)
    buf[n] = fib

    return fib