import heapq
from bisect import bisect_left,bisect_right

def solution(N, stages):
    answer = []
    stages.sort()
    length = len(stages)
    left = bisect_left(stages,1)
    
    for i in range(1,N+1):
        right = bisect_right(stages,i)
        icount = right-left
        if icount == 0:
            heapq.heappush(answer,(1,i))
        else:
            heapq.heappush(answer,(1-(icount/length),i))
        length -= icount
        left = right
    
    result = []
    while answer:
        result.append(heapq.heappop(answer)[1])
    return result