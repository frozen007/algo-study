"""
5. 最长回文子串
https://leetcode-cn.com/problems/longest-palindromic-substring/

# tag(dp)
"""

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        dp = [[False]*n for _ in range(n)]

        p_str = ""

        for l in range(n):
            for i in range(n-l):
                j = i + l

                if l == 0:
                    dp[i][j] = True
                elif l == 1:
                    if s[i]==s[j]:
                        dp[i][j] = True
                else:
                    if s[i]==s[j] and dp[i+1][j-1]:
                        dp[i][j] = True
                
                if dp[i][j]==True:
                    if len(p_str)<l+1:
                        p_str = s[i:j+1]
        
        return p_str