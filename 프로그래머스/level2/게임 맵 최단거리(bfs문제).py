from collections import deque

dx = [1,-1,0,0]
dy = [0,0,1,-1] #동서남북
def bfs(x,y,maps):
    q = deque()
    q.append((x,y))
    
    while q:
        x,y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            
            if a<0 or a> len(maps)-1 or b < 0 or b > len(maps[0])-1:
                continue
            
            if maps[a][b] == 1: #1이면 방문하지 않은 경로
                maps[a][b] = maps[x][y] + 1
                q.append((a,b))
    print(maps)            
    return maps[len(maps)-1][len(maps[0])-1]
        
def solution(maps):
    a = bfs(0,0,maps)
    if a == 1:
        return -1
    else:
        return a