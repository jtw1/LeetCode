#
# @lc app=leetcode.cn id=7 lang=python3
#
# [7] 整数反转
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        s=0
        a=abs(x)
        boundry=(1<<31)-1 if x>0 else (1<<31)
        while(a!=0):
            s=s*10+(a%10)
            a//=10
        if s>boundry:
            return 0
        return s if x>0 else -s
