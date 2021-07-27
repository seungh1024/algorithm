from bisect import bisect_left,bisect_right
import time

n,x = map(int,input().split())
data = list(map(int,input().split()))

start = time.time()
right_index = bisect_right(data,x)
left_index = bisect_left(data,x)

result = right_index-left_index
# print(right_index)
# print(left_index)

if result == 0:
    print(-1)
else:
    print(result)
end = time.time()
print(end-start)

#문제 해결 아이디어
#시간 복잡도 O(logN)으로 동작하는 알고리즘을 요구함
#   ->일반적인 선형 탐색으로는 시간 초과 판정을 받음
#   ->하지만 데이터가 정렬되어 있기 때문에 이진 탐색을 수행할 수 있음
#특정 값이 등장하는 첫 번째 위치와 마지막 위치를 찾아 위치 차이를 계산해 문제를 해결

#나와 마찬가지로 bisect라이브러리를 사용

#값이 [left_value,right_value]인 데이터의 개수를 반환하는 함수
def count_by_range(array,left_value,right_value):
    right_index = bisect_right(array,right_value)
    left_index = bisect_left(array,left_value) 
    return right_index - left_index

n,x = map(int,input().split()) #데이터 개수, 찾을 값 입력
array = list(map(int,input().split())) #전체 데이터 입력

#값이 [x,x] 범위에 있는 데이터의 개수 계산
count = count_by_range(array,x,x)

#값이 x인 원소가 존재하지 않으면
if count == 0:
    print(-1)
else:
    print(count)