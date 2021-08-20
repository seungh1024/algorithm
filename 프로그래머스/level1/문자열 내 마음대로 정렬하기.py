import heapq

def solution(strings, n):
    answer = []
    Q = []
    for i in strings:
        heapq.heappush(Q,(i[n],i))
    
    while Q:
        answer.append(heapq.heappop(Q)[1])

    return answer
