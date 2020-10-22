"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 24. 反转链表
https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head==None or head.next==None:
            return head
        
        new_head = head
        cur = head.next
        new_head.next=None
        while cur<> None:
            print cur.val
            buf = cur.next
            
            # link
            cur.next = new_head

            # make cur as new head
            new_head=cur

            cur = buf
        
        return new_head
