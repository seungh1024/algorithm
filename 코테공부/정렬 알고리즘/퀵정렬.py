#기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
#일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나
#병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 됨
#가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터로 설정함

# 5 7 9 0 3 1 6 2 4 8
# 위처럼 있다고 가정했을 때
# 첫 데이터를 기준 데이터로 정하면
# 현재 피벗 값은 5가 됨
# 왼쪽에서부터 5보다 큰 데이터를 선택하고 오른쪽에서부터 5보다 작은 데이터를 선택
# 이 두 데이터의 위치를 바꿔주면 됨
# 5 4 9 0 3 1 6 2 7 8 ->한 번 수행하면 이렇게 됨
# 5 4 2 0 3 1 6 9 7 8 ->두 번 수행
# 왼쪽에서 오다가 오른쪽에서 오다가 서로 위치가 엇갈리면
# 피벗과 작은 데이터의 위치를 서로 변경함
# 1 4 2 0 3 5 6 9 7 8 -> 5를 기준으로 왼쪽은 5보다 작고 오른쪽은 크게됨
# 이렇게 피벗을 기준으로 데이터 묶음을 나누는 작업을 분할 이라고 함
# 왼쪽에 있는 데이터에 대해 퀵 정렬 수행, 오른쪽에 대해서 퀵 정렬 각각 수행
# 재귀적으로 이 수행을 계속 하면 전체 데이터에 대해 수행함

# 이상적인 경우 분할이 절반씩 일어난다면 연산 횟수로 O(NlogN)을 기대할 수 있음
# 퀵 정렬은 평균 O(NlogN)의 시간 복잡도를 가짐
# 하지만 최악의 경우 O(N^2)의 시간 복잡도를 가짐
    #첫 번째 원소를 피벗으로 삼을 때, 이미 정렬된 배열에 퀵 정렬을 수행하면?
    # ->피벗값 자기 자신에서 자기 자신으로 바뀌기 때문에
    # 오른쪽으로 한 칸 옮겨서 분할해서 계속 퀵 정렬 수행함 ->O(N^2)

array = [5,7,9,0,3,1,6,2,4,8]

def quick_sort(array,start,end):
    if start >= end: #원소가 1개인 경우 종료
        return
    pivot = start #피벗은 첫 번째 원소
    left = start + 1
    right = end
    while(left <= right):
        #피벗보다 큰 데이터를 찾을 때까지 반복
        while(left <= end and array[left] <= array[pivot]):
            left += 1
        #피벗보다 작은 데이터를 찾을 때까지 반복
        while(right > start and array[right] >= array[pivot]):
            right -= 1
            if(left > right): #엇갈렸다면 작은 데이터와 피벗을 교체
                array[right],array[pivot] = array[pivot],array[right]
            else: #엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                array[left],array[right] = array[right],array[left]
        #분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행
    quick_sort(array,start,right-1)
    quick_sort(array,right+1,end)

quick_sort(array,0,len(array)-1)
print(array)
