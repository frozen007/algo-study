"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 18. 删除链表的节点
https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/

tips：前置指针算法
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
    def deleteNode(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        pre_head = ListNode()
        pre_head.val = 0
        pre_head.next = head
        cur = pre_head
        while cur.next<>None:
            if cur.next.val==val:
                cur.next = cur.next.next
                break
            cur = cur.next
        
        return pre_head.next