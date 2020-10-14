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
        m = [-1 for i in range(len(nums))] # previous LIS idx
        
        max_lis = 0
        max_idx = -1
        for i in range(len(nums)):
            for j in range(0, i):
                if nums[i]>nums[j]:
                    if f[j]+1 > f[i]:
                        f[i] = f[j]+1
                        m[i] = j

            if f[i]>max_lis:
                max_lis = f[i]
                max_idx = i
        
        for i in range(len(f)):
            print "f[%d]=%d" % (i, f[i])

        for i in range(len(m)):
            print "m[%d]=%d" % (i, m[i])
        
        print "max_lis=%d" % (max_idx)

        if max_lis>0:
            # 打印出LIS
            cur = max_idx
            lis_list = [nums[cur]]
            while m[cur]<>-1:
                lis_list.insert(0, nums[m[cur]])
                cur = m[cur]
                
            print lis_list

        return max_lis