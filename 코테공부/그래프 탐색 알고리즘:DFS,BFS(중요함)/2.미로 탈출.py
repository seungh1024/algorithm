# def dfs(x,y):
#     if x<=-1 or x >=N or y <=-1 or x >=M:
#         return False
#     if graph[x][y] == 1:
#         graph[x][y] = 0
#         dfs(x-1,y)
#         dfs(x+1,y)
#         dfs(x,y+1)
#         dfs(x,y-1)
#         return True
#     return False

# N,M = map(int,input().split())

# graph = []
# for i in range(N):
#     graph.append(list(map(int,input())))
# print(graph)

# for i in range(N):
#     for j in range(M):
#         if dfs(i,j) == True:
#             result +=1
#         else:
#             i +=1
#             result -=1

#아래 코드는 해결 아이디어 설명 듣고 작성한 것
from collections import deque


def bfs(x,y,z):
    if x<=-1 or x >=N or y <=-1 or y >=M:
        return False
    if graph[x][y] == 1:
        graph[x][y] = z+1
        bfs(x-1,y,graph[x][y])
        bfs(x+1,y,graph[x][y])
        bfs(x,y+1,graph[x][y])
        bfs(x,y-1,graph[x][y])
        return True

    return False
#위처럼 하면 정확한 값이 안나오는 이유는
#재귀적인 호출로 4개의 함수가 동시에 실행되는 것이 아니라
#한 함수의 재귀 호출이 전부 끝나면 그 다음 함수들이 실행되기 때문이다
#그러므로 막히지 않았으면 함수가 끝없이 전진하여 1을 모두 찾고 끝나기 떄문에
#위의 dfs를 이용한 함수는 적합하지 않다.
#이 전 문제의 막힌 공간을 찾는 유형에는 적합하다
#미로는 큐를 이용하여 하나씩 방문을 해야하는 것 같다.


N,M = map(int,input().split())

queue = deque([0,0])
graph = []
for i in range(N):
    graph.append(list(map(int,input())))
print(graph)

for i in range(N):
    for j in range(M):
        bfs(i,j,0)
print(graph[N-1][M-1])
print(graph)


#모범답안
#문제해결 아이디어
#-BFS는 시작 지점에서 가까운 노드부터 차례대로 그래프의 모든 노드를 탐색한다
#-상,하,좌,우로 연결된 모든 노드로의 거리가 1로 동일하다
#   ->따라서(1,1)지점부터 BFS를 수행하여 모든 노드의 최단 거리 값을 기록하면 해결할 수 있다
#-예시로 3x3크기의 미로가 있다고 가정하자
# 110
# 010
# 011
#처음에 (1,1)의 위치에서 시작한다
#값이 1인 노드로만 이동이 가능하다고 판단하여 처리(BFS진행)
#좌표에서 상,하,좌,우로 탐색을 진행하면서 바로 옆 노드인 (1,2)위치의 노드를 방문하고
#새롭게 방문하는 (1,2) 노드의 값을 2로 바꾸게 된다 -> 거리를 표현하는 것
#해당 노드들을 방문하면 큐에 넣고 다시 꺼내어 주변 노드를 확인하는 방식을 이용한다
#다음 노드를 방문할 때에는 이전 노드의 거리값 +1을 한 값을 기록해 준다
#이렇게 하여 결국 마지막에 기록된 거리값을 출력하면 되는 것이다
#아래는 모범답안 코드

#BFS 소스코드 구현
def bfs(x,y):
    #큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque()
    queue.append((x,y))
    #큐가 빌 때까지 반복하기
    while queue:
        x,y = queue.popleft()
        #현재 위치에서 4가지 방향으로의 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #미로 찾기 공간을 벗어난 경우 무시
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            #벽인 경우 무시
            if graph[nx][ny] == 0:
                continue
            #해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] +1
                queue.append((nx,ny))
                
    #가장 오른쪽 아래까지의 최단 거리 반환
    return graph[n-1][m-1]

from collections import deque

#N,M을 공백을 기준으로 구분하여 입력받기
n,m = map(int,input().split())
#2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int,input())))
print(graph)

#이동할 네 가지 방향 정의(상,하,좌,우)
dx = [-1,1,0,0]
dy = [0,0,-1,1]

#BFS를 수행한 결과 출력
print(bfs(0,0))