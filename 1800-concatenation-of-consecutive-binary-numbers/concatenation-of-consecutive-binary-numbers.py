class Solution:
    def concatenatedBinary(self, n: int) -> int:
        res,mod=0,10**9+7
        for i in range(n):
            res=(res*(1<<(len(bin(i+1))-2))+i+1)%mod
        return res
