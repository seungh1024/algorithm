def solution(s):
    a = len(s)
    if a % 2 == 0:
        return s[a//2-1]+s[a//2]
    return s[a//2]