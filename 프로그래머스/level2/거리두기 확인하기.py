from collections import defaultdict

def solution(places):
    answer = [1,1,1,1,1]
    data = defaultdict(list)
    def dfs(a,b,count,i):
        if a<0 or a>4 or b<0 or b>4 or count >2: #인덱스 범위를 벗어나면 리턴
            return 1
        if places[i][a][b] == 'P' and graph[a][b] == 0 and count>0: #P를 만나면 answer값을 바꿔줌
            answer[i] = 0
            return 0
        if places[i][a][b] == 'X': #x를 만나면 방문처리하고 리턴함 -> 다른 P에서 시작해도 벽으로 인식
            graph[a][b] =1
            return 1
        if graph[a][b] ==0: #방문하지 않은곳이면
            graph[a][b] = 1 #방문처리 후 각각 한칸씩 이동하며 탐색
            dfs(a+1,b,count+1,i)
            dfs(a-1,b,count+1,i)
            dfs(a,b+1,count+1,i)
            dfs(a,b-1,count+1,i)
            return 1
             
        return 1

    #P만 찾아서 data에 넣어줌
    for i in range(5): 
        graph=[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]] #방문처리를 위한 그래프
        for j in range(5):
            for index,value in enumerate(places[i][j]):
                if value == 'P':
                    # data[i].append((j,index))
                    dfs(j,index,0,i)
    
    
            
    # for i in range(5): #각 방마다 수행
    #     graph=[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]] #방문처리를 위한 그래프
    #     if data[i]: #P가 있다면
    #         for a,b in data[i]: 
    #             dfs(a,b,0,i) #탐색수행
            
    return answer