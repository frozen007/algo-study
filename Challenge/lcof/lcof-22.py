"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 22. 链表中倒数第k个节点
https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

tips：双指针算法
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getKthFromEnd(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        f,l = head, head

        for _ in range(k):
            f = f.next

        while f<>None:
            f = f.next
            l = l.next

        return l