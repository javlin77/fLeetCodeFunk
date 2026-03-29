class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        count = [0] * 26

        for i in range(len(s1)):
            count[ord(s1[i]) - ord('a')] += 1
            count[ord(s2[i]) - ord('a')] -= 1

        for c in count:
            if c != 0:
                return False

        if s1 == s2:
            return True

        if s1[0] == s2[2] and s2[0] == s1[2]:
            return True
        elif s1[1] == s2[3] and s2[1] == s1[3]:
            return True
        else:
            return False
        