N = int(input())
data = list(map(int, input().split()))
data.sort(reverse = True)

result = 0
i=0

while i < N:
    if(data[i + data[i] - 1]):
        result +=1
        i = i+data[i]
    # else:

print(result)

#문제 해결 아이디어
#오름차 순 정렬 이후에 공포도가 가장 낮은 모험가부터 하나씩 확인
#앞에서부터 공포도를 하나씩 확인하며 현재 그룹에 포함된 모험가의 수가 현재 확인하고 있는
#공포도보다 크거나 같다면 이를 그룹으로 설정하면 됨
#이러한 방법을 이용하면 공포도가 오름차순으로 정렬되어 있다는 점에서, 항상 최소한의 모험가의
#수만 포함하여 그룹을 결성하게 됨

#모범 답안
n = int(input())
data = list(map(int,input().split()))
data.sort()

result = 0 # 총 그룹의 수
count = 0 # 현재 그룹에 포함된 모험가의 수

for i in data: #공포도를 낮은 것부터 하나씩 확인하며
    count += 1 #현재 그룹에 해당 모험가를 포함시킴
    if count >= i: #현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면 그룹 결성
        result +=1 #총 그룹의 수 증가시킴
        count = 0 #현재 그룹에 포함된 모험가의 수 초기화

print(result)