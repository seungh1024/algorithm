from collections import defaultdict
from itertools import combinations

def solution(clothes):
    answer = 1
    data = defaultdict(int)
    
    for a,b in clothes:
        data[b] += 1
        
    a = list(data.values())
    # for i in range(1,len(data)+1):
    #     result = list(combinations(a,i))
    #     for k in result:
    #         count = 1
    #         for num in k:
    #             count *=num
    #         answer += count
    for i in a:
        answer *= (i+1)
    #각 옷의 개수와 안입는 경우가 있으므로 +1을 해줌
    #마지막에 -1을 해주는 이유는 모두 안입는 경우가 있으므로
    #옷은 무조건 하나는 입어야 하므로 -1을 하는것
    
    return answer-1