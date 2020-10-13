"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 11. 旋转数组的最小数字
https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
"""
class Solution(object):
    def minArray(self, numbers):
        """
        :type numbers: List[int]
        :rtype: int
        """
        low=0
        high=len(numbers)-1
        mid = (low + high)/2

        target = 0

        if high==0:
            return numbers[low]

        while True:
            if numbers[mid]>numbers[high]:
                # in right, not include mid
                low = mid+1
                if low==high:
                    target = numbers[low]
                    break
            elif numbers[mid]<numbers[high]:
                # in left, include mid
                high = mid
                if low==high:
                    target = numbers[low]
                    break
            else:
                # move to next high
                high = high - 1
                if low==high:
                    target = numbers[low]
                    break
            
            mid = (low + high)/2


        return target


