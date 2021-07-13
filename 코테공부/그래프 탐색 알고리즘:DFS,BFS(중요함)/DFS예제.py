def dfs(graph, v, visited):
    #현재 노드를 방문 처리
    visited[v] = True
    print(v, end = ' ')
    #현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

#각 노드가 연결된 정보를 표현
graph = [
    [],#노드의 번호가 1번부터 시작하는 경우가 많기 때문에 인덱스 0은 비워둠
    [2,3,8],#1번 노드는 2,3,8번 노드와 연결됨
    [1,7],#2번 노드는 1,7번 노드와 연결됨
    [1,4,5],#3번 노드는 1,4,5번과 연결된 것
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False]*9 #기본적으로 모든 값들은 False로 초기화하여 방문하지 않은것 처럼 함

dfs(graph,1,visited)