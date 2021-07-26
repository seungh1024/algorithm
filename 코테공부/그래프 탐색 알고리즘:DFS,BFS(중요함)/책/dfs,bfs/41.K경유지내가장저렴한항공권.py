from collections import defaultdict
import heapq

n = int(input())

data =[]
for i in range(n):
    data.append(list(map(int,input().split())))

graph = defaultdict(list)
#해당 노드에서 다음 노드로의 정보를 넣어줌
#다음노드, 가격, 거리 순 ->거리는 처음에 0이니 0으로 하고 더해줄 예정
for a,b,c in data:
    graph[a].append((b,c))

src,dst,k = map(int,input().split())

print(n,data,src,dst,k)
print(graph)

answer = []
result = defaultdict(list)
def fun():
    #경유지,가격,시작점 순
    queue = [(0,0,src)]

    while queue:
        time,pay,start = heapq.heappop(queue)
        
        if time > k+1:
            return
        if start == dst:
            answer.append(pay)
        if start not in result:
            #갔던 곳인지 체크   
            result[start] =(time+1,pay)
            #b가 도착지 c가 가격
            for b,c in graph[start]:
                heapq.heappush(queue,(time+1,pay+c,b))

fun()
if answer != []:
    print(min(answer))
else:
    print(-1)
    