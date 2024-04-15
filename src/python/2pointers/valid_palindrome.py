class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ''

        for a in s:
            if a.isalpha() or a.isdigit():
                newStr += a.lower()
        
        return (newStr == newStr[::-1])
        