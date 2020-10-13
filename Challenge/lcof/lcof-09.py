"""
剑指 Offer（第 2 版）
https://leetcode-cn.com/problemset/lcof/

剑指 Offer 09. 用两个栈实现队列
https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
"""
class CQueue(object):

    def __init__(self):
        self.s_a = []
        self.s_b = []

    def appendTail(self, value):
        """
        :type value: int
        :rtype: None
        """
        # transfer to b
        while len(self.s_a)>0:
            self.s_b.append(self.s_a.pop())
        
        self.s_a.append(value)

        while len(self.s_b)>0:
            self.s_a.append(self.s_b.pop())

    def deleteHead(self):
        """
        :rtype: int
        """
        if(len(self.s_a)==0):
            return -1

        return self.s_a.pop()



# Your CQueue object will be instantiated and called as such:
# obj = CQueue()
# obj.appendTail(value)
# param_2 = obj.deleteHead()