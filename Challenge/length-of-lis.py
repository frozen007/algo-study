'''
300. 最长上升子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/
'''

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        f = [1 for i in range(len(nums))]
        
        max_lis = 0
        for i in range(len(nums)):
            for j in range(0, i):
                if nums[i]>nums[j]:
                    f[i] = max(f[j]+1, f[i])

            if f[i]>max_lis:
                max_lis = f[i]
        
        for i in range(len(f)):
            print "f[%d]=%d" % (i, f[i])

        return max_lis
