t = int(input())
def gold():
    n,m = map(int,input().split())
    data = list(map(int,input().split()))
    
    #2차원 배열로 바꿔주기
    case = []
    for i in range(n):
        #m개씩 각각 넣어서 2차원으로 만들었음
        case.append(data[i*m:(i+1)*m])
    # print(case)
    
    #이동위치 -> 앞에서 뒤에값을 받아와서 더할 예정
    x =-1
    y =[0,1,-1]
    maxgold = [0]
    for i in range(1,m):
        for j in range(n):
            #이동했을 때 값들을 저장하기 위한 check
            check = []
            for k in range(3):
                dy = j+y[k]
                dx = i+x
                print(dy,dx)
                if dy >=0 and dy < n and dx >=0 and dx < m:
                    #각 값들이 범위를 벗어나지 않으면 check에 추가
                    # check.append(case[dy][dx])
                    #배열로 옮겨서 하니 1x1등의 행렬에서 에러가 발생함
                    #왜냐하면 해당 반복문을 진입을 못하기 때문
                    #그래서 바로 비교해서 넣는 것으로 변경
                    case[j][i] += max(case[j][i],case[dy][dx])

            #check값 중 가장 큰 값을 현재 위치에 더함
            # case[j][i] += max(check)
            #마지막 열일 때 각 값들이 그 행의 최대값이니 추가해줌
            # if i == m-1:
            #     maxgold.append(case[j][i])
    # print(case)
    #각 행의 최댓값들 중 가장 큰 값을 리턴해줌
    #위처럼 변경하고나니 1x1같은 경우는 기존 행렬의 값을 반환하는 것이 됨
    #맨 마지막 열만 모두 배열에 넣어서 가장 큰 값을 리턴해줌
    for i in range(n):
        maxgold.append(case[i][m-1])
    return max(maxgold)
            


        
result = []
for i in range(t):
    result.append(gold())

for i in range(len(result)):
    print(result[i])


print('------------모범 답안--------------')
#문제 해결 아이디어
#-금광의 모든 위치에 대하여 다음의 세 가지만 고려하면 됨
#1.왼쪽위에서 오는 경우
#2.왼쪽 아래에서 오는 경우
#3.왼쪽에서 오는 경우
#-세가지 경우 중에서 가장 많은 금을 가지고 있는 경우를 테이블에 갱신해주어 해결

#array[i][j] = i행 j열에 존재하는 금의 양
#dp[i][j] = i행 j열까지의 최적의 해 (얻을 수 있는 금의 최댓값)
#점화식은 다음과 같음
#dp[i][j] = array[i][j] + max(dp[i-1][j-1],dp[i][j-1],dp[i+1][j-1])
#이때 테이블에 접근할 때마다 리스트의 범위를 벗어나지 않는지 체크해야 함
#편의상 초기 데이터를 담는 변수 array를 사용하지 않아도 됨
#   바로 dp 테이블에 초기 데이터를 담아서 다이나믹 프로그래밍 적용할 수 있음

#테스트 케이스 입력
for tc in range(int(input())):
    #금광 정보 입력
    n,m = map(int,input().split())
    array = list(map(int,input().split()))
    #다이나믹 프로그래밍을 위한 2차원 dp 테이블 초기화
    dp = []
    index = 0
    for i in range(n):
        dp.append(array[index:index+m])
        index += m
    #다이나믹 프로그래밍 진행
    for j in range(1,m):
        for i in range(n):
            #왼쪽 위에서 오는 경우
            if i == 90:
                left_up = 0
            else:
                left_up = dp[i-1][j-1]
            #왼쪽 아래에서 오는 경우
            if i == n-1:
                left_down = 0
            else:
                left_down = dp[i+1][j-1]
            #왼쪽에서 오는 경우
            left = dp[i][j-1]
            dp[i][j] = dp[i][j] + max(left_up, left_down,left)
    result = 0
    for i in range(n):
        result = max(result,dp[i][m-1])
    print(result)