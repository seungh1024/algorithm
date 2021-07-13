# from collections import deque

# N,M = map(int,input().split())

# array = []

# for i in range(N):
#     n = input()
#     array.append(n)

# # print(array)

# # for i in range(len(array[0])):
# #     print(array[0][i])

# queue = deque([(0,0)])
# # queue.append((1,1))
# # print(queue)

# while True:
#     hole = queue.popleft()
#     x = hole[0]
#     y = hole[1]
#     if(array[x][y] == '0'):
#         if(x<4):
#             x +=1
#             queue.append((x,y))
#         else:
#             y +=1
            
#문제풀이
#문제 해결 아이디어
#-이 문제는 DFS 혹은 BFS로 해결할 수 있다. 일단 앞에서 배운 대로 얼음을 얼릴 수 있는
# 공간이 상,하,좌,우로 연결되어 있다고 표현할 수 있으므로 그래프 형태로 모델링 할 수 있다.
# 다음과 같이 3x3 크기의 얼음틀이 있다고 가정하자
# 상하좌우로 인접한 곳이고 0인 곳은 전부 방문 처리 하는 것
# 1을 만나면 그건 방문안한 것으로 처리
#-DFS를 활용하는 알고리즘은 다음과 같다
#   1.특정한 지점의 주 변 상,하,좌,우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직
#     방문하지 않은 지점이 있다면 해당 지점을 방문한다.
#   2.방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 진행하는 과정을 반복하면,
#     연결된 모든 지점을 방문할 수 있다.
#   3.모든 노드에 대하여 1~2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트한다.

#DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
def dfs(x,y):
    #주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y>=m:
        return False
    #현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 0:
        #해당 노드 방문 처리
        graph[x][y] = 1
        #상,하,좌,우의 위치들도 모두 재귀적으로 호출
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False

n,m = map(int,input().split())

#2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int,input())))

print(graph)

#모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        #현재 위치에서 DFS 수행
        #그 위치랑 붙어있는 곳을 다 수행함
        #수행하고 True가 반환되면 붙어있는 곳 다 찾은 것
        #후에 i,j값들이 증가하며 그 자리에서 수행
        #다음값들이 graph에 있으면 어차피 False를 반환할 것임
        #그렇게 행렬값의 모든 값들에 대해 수행하여 카운트 해주는 것
        if dfs(i,j) == True:
            result +=1

print(result) #정답 출력
