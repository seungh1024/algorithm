n,k = map(int,input().split())
A = list(map(int,input().split()))
B = list(map(int,input().split()))

# print(n,k,A,B)

A.sort()
B.sort() #B.sort(resverse = True)를 사용하여 내림차순으로 정렬하면
#아래 코드가 조금 더 보기 쉬웠을 듯

result = 0
for i in range(len(A)):
    if(i < k):
        A[i] = B[len(B)-i-1]
    result += A[i]
#나는 for문으로 합했지만 sum(A)를 하는 것도 좋았을 듯
#k만큼 교체해야하니 그것 때문에 이왕 다 합할거 한번에 하기위해 이렇게 했음

print(A)
print(result)

#문제 해결 아이디어
#핵심 아이디어: 매번 배열 A에서 가장 작은 원소를 골라 배열 B에서 가장 큰원소와 교체
#가장 먼저 배열 A와 배열 B가 주어지면 A에대하여 오름차순 정렬,B에대해 내림차순 정렬
#이후에 두 배열의 원소를 첫 번째 인덱스부터 차례로 확인하면서 A의원소가 B의원소보다
#작을때에만 교체를 수행
#이 문제에서는 두 배열의 원소가 최대 100000개까지 입력가능하므로 최악의 경우
#O(NlogN)을 보장하는 정렬 알고리즘을 이용해야함
