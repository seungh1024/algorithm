from collections import deque

def solution(prices):
    answer = []
    q = deque(prices)
    length = len(prices)
    
    for i in range(length):
        count = 0
        a = q.popleft()
        for k in q:
            count += 1
            if k< a:
                break
        answer.append(count)
        
    return answer