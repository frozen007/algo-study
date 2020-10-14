'''
1143. 最长公共子序列
https://leetcode-cn.com/problems/longest-common-subsequence/
'''
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        f = [[0] * (len(text2) +1) for _ in range(len(text1) +1)]

        max_lcs = 0
        for i in range(1, len(text1) +1):
            for j in range(1, len(text2) +1):
                if text1[i-1] == text2[j-1]:
                    f[i][j] = f[i-1][j-1] + 1
                else:
                    f[i][j] = max(f[i-1][j], f[i][j-1])
            
            if f[i][j]>max_lcs:
                max_lcs = f[i][j]
        
        for i in range(0, len(text1) +1):
            print f[i]
        
        return max_lcs