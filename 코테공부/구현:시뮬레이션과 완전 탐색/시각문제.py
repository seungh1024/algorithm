import time

N = int(input())
start_time = time.time()
count = 0

#분단위
for i in range(60):
    #초단위
    if(i == 3 or i == 13 or i ==23 or i == 43 or i ==53 or (i>=30 and i<=39)):
        count +=60
    else:
        count +=15
    #for j in range(60):
        
        # else:
        #     if(j == 3 or j == 13 or j == 23 or j == 43 or j == 53 or (j>=30 and j<=39)):


print(count)
if(N>=23):#3,13,23 의 세가지는 따로 60*60을 더해줘야 하므로 N-2를 해줌
    count = count*(N-2) + 60*60*3
elif(N>=13):#3,13의 두 가지 경우는 따로 60*60을 더해줘야 하므로 N-1을 해줌
    count = count*(N-1) + 60*60*2
elif(N>=3):
    count = count*N + 60*60
else:
    count = count*(N+1)
      
   
print(count)
end_time = time.time()
print(end_time - start_time)

#모범 답안
#문제 해결 아이디어
#이 문제는 가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있는 문제
#하루는 86400초이므로 00시00분00초부터 23시 59분59초까지의 모든 경우는 86400가지
#   ->24*60*60 = 86400
#따라서 단순히 시각을 1씩 증가시키며 3이 하나라도 포함되어 있는지를 확인
#이러한 유형은 완전 탐색 문제 유형이라고 불림 ->가능한 경우의 수를 모두 검사하는 탐색 방법

h = int(input())
start_time = time.time()
count = 0
for i in range(h+1):
    for j in range(60):
        for k in range(60):
            #매 시각 안에 3이 포함되어 있다면 카운트 증가
            if '3' in str(i) +str(j)+str(k):
                count +=1
print(count)
end_time = time.time()
print(end_time-start_time)