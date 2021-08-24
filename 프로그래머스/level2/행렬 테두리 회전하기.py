def solution(rows, columns, queries):
    answer = []
    x = [1,0,-1,0] #x좌표 움직이는 방향
    y = [0,1,0,-1] #y좌표 움직이는 방향  오,아래,왼,위 순서
    
    data = [] #행렬 정보를 담아줄 데이터
    
    count = 1
    for i in range(rows):  #행렬 초기화
        num = []
        for j in range(columns):
            num.append(count)
            count += 1
        data.append(num)
            
    for query in queries:
        dx = query[0]-1
        dy = query[1]-1 #출발점
        print(dx,dy)
        minimum = data[dx][dy] #최소값을 저장할 변수
        origin = minimum #현재값을 저장할 변수
        for i in range(4):
            while True:
                dx += y[i]
                dy += x[i] #x,y좌표 이동
                
                if dx < query[0]-1 or dx > query[2]-1 or dy < query[1]-1 or dy > query[3]-1:
                    dx -= y[i]
                    dy -= x[i]
                    break #범위를 벗어나면 더해준 것 만큼 빼고 탈출
                    
                k = data[dx][dy] #이동한 시점의 값
                minimum = min(minimum,k) #작은값 저장
                data[dx][dy] = origin #이동한 좌표를 이전의 값으로 바꿔줌
                origin = k #현재 위치의 값을 넣어서 다음좌표로 한칸 이동하면 바꿔줌
        
        answer.append(minimum) #각 최솟값을 추가
            
    return answer