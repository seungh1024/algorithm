import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) #무한을 의미한는 값으로 10억을 설정

#노드의 개수, 간선의 개수를 입력받기
n,m = map(int,input().split())
#시작 노드 번호를 입력받기
start = int(input())
#각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n+1)]
#최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n+1)

#모든 간선 정보를 입력받기
for _ in range(m):
    a,b,c = map(int,input().split())
    #a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    graph[a].append((b,c))

def dijkstra(start):
    q = []
    #시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q: #큐가 비어있지 않다면
        #가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        #현재 노드가 이미 처리된 적이 있는 노드라면 무시
        #더 큰 시간이 걸리는 값이면 무시하는 것
        #distance는 기본 값으로 무한을 가지고 있기 때문에
        #distance가 dist보다 작으면 이미 더 좋은 경로가 있는 것임
        if distance[now] <dist:
            continue
        #현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            #현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))

#다익스트라 알고리즘을 수행
dijkstra(start)

#모든 노드로 가기 위한 최단 거리를 출력
for i in range(1,n+1):
    #도달할 수 없는 경우, 무한(INFINITY)이라고 출력
    if distance[i] == INF:
        print('INFINITY')
    #도달할 수 있는 경우 거리를 출력
    else:
        print(distance[i])

#성능 분석
#-힙 자료구조를 이용하는 다익스트라 알고리즘의 시간 복잡도는 O(ElogV)이다
#-노드를 하나씩 꺼내 검사하는 반복문(while문)은 노드의 개수 v이상의 횟수로는
#  처리되지 않음
#   -결과적으로 현재 우선순위 큐에서 꺼낸 노드와 연결된 다른 노드들을 확인하는
#    총횟수는 최대 간선의 개수(E)만큼 연산이 수행될 수 있음
#-직관적으로 전체 과정은 E개의 원소를 우선순위 큐에 넣었다가 모두 빼내는 연산과
#  매우 유사함
#   -시간 복잡도를 O(ElogE)로 판단할 수 있음
#   -중복 간선을 포함하지 않는 경우에 이를 O(ElogV)로 정리할 수 있음
#       -O(ElogE) -> O(ElogV^2) -> O(2ElogV) -> O(ElogV)