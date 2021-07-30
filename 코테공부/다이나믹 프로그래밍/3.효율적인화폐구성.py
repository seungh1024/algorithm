n,m = map(int,input().split())
money = []
for i in range(n):
    money.append(int(input()))
# print(money)

count = [0]*(m+1)
count[0] = 1
# i = 0
# count[i] = 0
# while True:
#     if i+2 <15:
#         count[i+2] = count[i]+

for i in range(money[0],m+1):
    for j in range(len(money)):
        #현재 가격에서 화폐만큼 뺀 것이 이전에 세어진 적 있으면
        if count[i-money[j]] !=0: 
            #현재가격이 0이면 이전의 개수에서 +1을 해줌
            if count[i] == 0:
                count[i] = count[i-money[j]]+1
            #이미 다른 화폐로 세어진 것이면 현재가격과 이전값에서+1한 것 중
            #작은 값을 넣어줌 다른 화폐와 세었을 때 작은 값을 넣는 것
            else:
                count[i] = min(count[i],count[i-money[j]]+1)
        # elif i-3 >=0:
        #     count[i] = min(count[i],count[i]+1)
print('답:',count[m]-1) #0일 때 1로 시작했으니 1을 빼줌
print('------------------------')

#문제해결 아이디어
#ai = 금액 i를 만들 수 있는 최소한의 화폐 개수
#k = 각 화폐의 단위
#점화식: 각 화폐 단위인 k를 하나씩 확인하며
#   -a<i-k>를 만드는 방법이 존재하는 경우, ai = min(ai,a<i-k>+1)
#   -a<i-k>를 만드는 방법이 존재하지 않는 경우 -> ai = INF

#n=3,m=7 이고 각 화폐의 단위가 2,3,5인 경우 확인해보면
#먼저 각 인덱스에 해당하는 값으로 INF(무한)의 값을 설정한다
#INF는 특정 금액을 만들 수 있는 화폐 구성이 가능하지 않는다는 의미를 가짐
#나는 if문을 사용해서 처리했지만 이처럼 하면 min을 이용하기 편할 것임
#본 문제에서는 10,001을 사용할 수 있다
#인덱스0은 0을, 1부터 m까지는 모든 금액에 대해서 아직 만들 수 없다는 뜻으로 
#10001로 초기화를 함
#그 다음으론 매 인덱스를 확인하며 첫 번쨰 화폐 단위인 2를 확인하면
#점화식에 따라서 리스트가 변경되는 것. 0원에서 1을 더해서 2원에는 1이됨
#4원은 2원의 값에서 1을 더한 2가 되는 것

#모범답안
array = []
for i in range(n):
    array.append(int(input()))

#한 번 계산된 결과를 저장하기 위한 DP테이블 초기화
d = [100001] * (m+1) #10001인 이유는 최대 10000이 입력되기 떄문

#다이나믹 프로그래밍 진행(보텀업)
d[0] = 0
for i in range(n):
    for j in range(array[i],m+1):
        if d[j-array[i]] != 10001: #(i-k)원을 만드는 방법이 존재하는 경우
            d[j] = min(d[j], d[j-array[i]]+1)

#계산된 결과 출력
if d[m] == 10001: #최종적으로 M원을 만드는 방법이 없는 경우
    print('답:',-1)
else:
    print('답:',d[m])