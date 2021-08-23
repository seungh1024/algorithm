import heapq

def solution(scoville, K):
    scoville.sort()
    # 나는 기존의 리스트를 힙으로 이용하니 오류가 생겨서
    # 가장 작은값부터 빼내는거니까 sort로 정렬을 했음
    # 힙 모듈에서 heapify()를 사용하면 기존의 리스트를 힙구조로 바꾸어 줌
    # 시간 복잡도는 O(N)이며 heapq.heapify(scoville)을 하면 됨
    
    count = 0
    while scoville:
        a = heapq.heappop(scoville) #1번째 -> 가장 맵지 않은 음식
        if a >= K:
            break
        if scoville == []: #모두 K이상으로 만들지 못하면 -1반환
            return -1
            
        b = heapq.heappop(scoville) #2번쨰 -> 두 번째로 맵지 않은 음식
        heapq.heappush(scoville,a+2*b) #쉐낏
        count += 1
        
    return count
