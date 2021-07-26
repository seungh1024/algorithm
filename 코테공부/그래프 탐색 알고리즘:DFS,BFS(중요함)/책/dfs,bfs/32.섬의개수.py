n,m = map(int,input().split())

graph = []
result = 0
for i in range(n):
    graph.append(list(map(int,input())))

def dfs(x,y):
    if x<0 or x>=n or y<0 or y >=m:
        return False
    if graph[x][y] == 1:  #육지면 재귀적으로 호출함
        graph[x][y] = 0   #방문처리
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1)
        return True #재귀호출 끝나면 주변구역 탐색이 끝난 것이고 True 반환
    return False   #0을 방문하면 False 반환하도록    

for i in range(n):
    for j in range(m):
        if dfs(i,j) == True:
            result +=1

print(result)