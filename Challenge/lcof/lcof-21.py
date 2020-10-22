"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/

"""

class Solution(object):
    def exchange(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        h, t = 0, len(nums)-1

        while h<t:
            while nums[h]%2>0:
                h = h + 1
                if h>=len(nums):
                    break
            
            while nums[t]%2==0:
                t = t - 1
                if t<0:
                    break
            
            if h>=t:
                break
            
            buf = nums[h]
            nums[h]=nums[t]
            nums[t]=buf
        
        return nums