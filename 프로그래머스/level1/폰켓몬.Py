from itertools import combinations
def solution(nums):
    ponketmon = set(nums)
    numlen = len(nums)//2
    numpon = len(ponketmon)
    if numpon <= numlen:
        return numpon
    else:
        return numlen