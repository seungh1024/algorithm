#다이나믹 프로그래밍으로 풀었음

def solution(land):
    answer = 0
    d = []
    d.append(land[0])
    for i in range(len(land)-1):
        d.append([0,0,0,0])
    
    for i in range(1,len(land)):
        for j in range(4):
            for k in range(4):
                if j != k:
                    d[i][j] = max(d[i][j],land[i][j]+d[i-1][k])
    
    
    return max(d[-1])