from collections import defaultdict
import heapq

n,m = map(int,input().split())

way = defaultdict(list)
for i in range(m):
    a,b = map(int,input().split())
    if a == 1: #출발지면 한 경로만 추가
        way[a].append(b)
    else: #출발지가 아니면 양방향 이동 가능하므로 둘 다 추가
        way[a].append(b)
        way[b].append(a)
x,k = map(int,input().split())
print(way)

def fun(time,start,end):
    Q = [(time,start)] #(시간,출발지) 
    visited = defaultdict(int)

    while Q:
        time,node = heapq.heappop(Q) #시간, 경로를 담아줌
        if node not in visited:
            visited[node] = time
            for i in way[node]:
                heapq.heappush(Q,(time+1,i))
    
    return visited[end]

checkpoint = fun(0,1,k)
result =fun(checkpoint,k,x)
if result > 1:
    print(result)
else:
    print(-1)

print('----------강의 코드------------')

# 문제해결 아이디어
# -전형적인 최단 거리 문제 -> 최단거리 알고리즘 적용
# -n의 크기가 최대 100이므로 플로이드 워셜 알고리즘도 이용 가능
# -플로이드 워셜 알고리즘을 수행한 뒤
#(1번 노드에서 x까지의 최단거리+x에서 k까지의 최단거리)를 계산하여 출력하면 정답

INF = int(1e9) #무한을 의미하는 값으로 10억 설정

#노드의 개수 및 간선의 개수를 입력받기
n,m = map(int,input().split())
#2차원 리스트(그래프 표현)를 만들고, 모든 값을 무한으로 초기화
graph =[[INF] * (n+1) for _ in range(n+1)]

#자기 자신에서 자기 자신으로 비용은 0으로 초기화
for a in range(1,n+1):
    for b in range(1,n+1):
        if a == b:
            graph[a][b] = 0

#각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
for _ in range(m):
    #A와 B가 서로에게 가는 비용은 1이라고 설정
    a,b = map(int,input().split())
    graph[a][b] = 1
    graph[a][b] = 1

#거쳐 갈 노드 x와 최종 목적지 노드 k를 입력받기
x,k = map(int,input().split())

#점화식에 따라 플로이드 워셜 알고리즘 수행
for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b],graph[a][k]+graph[k][b])

#수행된 결과를 출력
distance = graph[1][k] + graph[k][x]

#도달할 수 없는 경우, -1을 출력
if distance >= INF:
    print(-1)
#도달할 수 있다면 최단 거리를 출력
else:
    print(distance)


# 5 7
# 1 2
# 1 3
# 1 4
# 2 4
# 3 4
# 3 5
# 2 5
# 4 5
# 이렇게 값을 넣으면 4가 되야하는데 강의코드는 -1이 반환됨
# 개인적인 생각으론 내가한 코드처럼 하는게 맞는 것 같음
# 도로를 이동하는 것이니 왕복이 가능한 것이고
# 중간 지점까지 다익스트라, 다시 중간점에서 목표까지 다익스트라 알고리즘을 수행하면
# 최소 시간이 나오게 되어있음