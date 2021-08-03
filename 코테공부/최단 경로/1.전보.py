from collections import defaultdict
import heapq

n,m,c = map(int,input().split())

info = defaultdict(list) #입력 정보를 담는 사전 자료형
for i in range(m):
    x,y,z = map(int,input().split())
    info[x].append((y,z)) #x에서 y로 보내는데 걸리는 시간 z

visited = defaultdict(int) #도시의 개수 및 총 시간을 세기 위함
Q = [(0,c)] # (시간,출발지)

while Q:
    time,node = heapq.heappop(Q)
    if node not in visited: #방문하지 않았다면
        visited[node]=time  #방문처리 후
        for a,b in info[node]: #a는 다음 위치, b는 걸리는 시간
            # print(a,b)
            #걸린 시간만큼 기존의 시간에 더해서 큐에 넣어줌
            heapq.heappush(Q,(b+time,a)) 

print('총 도시의 수:',len(visited)-1)#자기 자신을 빼야해서 -1
print('걸리는 시간:',max(visited.values()))

print('-----------강의 답안 코드---------------')
# 문제 해결 아이디어
# -한 도시에서 다른 도시까지의 최단 거리 문제로 치환 가능
# -n,m의 범위가 충분히 크기 때문에 우선순위 큐를 활용한 다익스트라 알고리즘 구현
import sys
input = sys.stdin.readline
INF = int(1e9) #무한을 의미하는 값으로 10억을 설정

def dijkstra(start):
    q = []
    #시작 노드로 가기 위한 최단 거리는 0으로 설정하며 큐에 삽입
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q: #큐가 비어있지 않다면
        #가장 최단 거리가 짧은 노드에 대한 정보를 꺼냄
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        #현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist +i[1]
            #현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))
#노드의 개수, 간선의 개수, 시작 노드를 입력받음
n,m,start = map(int,input().split())
#각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n+1)]
#최단 거리 테이블을 모두 무한으로 초기화
distance = [INF]*(n+1)

#모든 간선 정보를 입력 받기
for _ in range(m):
    x,y,z = map(int,input().split())
    # x번 노드에서 y번 노드로 가는 비용이 z라는 의미
    graph[x].append((y,z))

#다익스트라 알고리즘을 수행
dijkstra(start)

#도달할 수 있는 노드의 개수
count = 0
#도달할 수 있는 노드 중에서 가장 멀리 있는 노드와의 최단 거리
max_distance = 0
for d in distance:
    #도달할 수 있는 노드인 경우
    if d != 1e9:
        count += 1
        max_distance = max(max_distance,d)

#시작 노드는 제외해야 하므로 count -1 을 출력
print(count-1,max_distance)