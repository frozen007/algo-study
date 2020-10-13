"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 06. 从尾到头打印链表
https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reversePrint(self, head):
        """
        :type head: ListNode
        :rtype: List[int]
        """
        
        if head==None:
            return list()
        
        new_head_ptr=head

        ptr_node = head

        while ptr_node<>None:
            temp_node = ptr_node.next
            ptr_node.next = new_head_ptr
            new_head_ptr = ptr_node
            ptr_node = temp_node
        
        head.next=None
                
        ret_list = list()
        ptr_node = new_head_ptr
        while ptr_node<>None:
            ret_list.append(ptr_node.val)
            ptr_node = ptr_node.next
        
        return ret_list



