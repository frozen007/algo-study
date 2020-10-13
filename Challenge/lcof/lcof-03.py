"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 03. 数组中重复的数字
https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
"""

class Solution(object):
    def findRepeatNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # hs as hashmap
        hs = [0 for i in range(len(nums))]
        for n in nums:
            hs[n] = hs[n] + 1
                
        for idx in range(len(hs)):
            if hs[idx]>1:
                return idx