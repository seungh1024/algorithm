#처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
#선택 정렬에 비해 구현 난이도가 높은 편이지만 일반적으로 더 빨리 동작함

array = [7,5,9,0,3,1,6,2,4,8]

for i in range(1,len(array)):
    for j in range(i,0,-1):#인덱스 i부터 1까지 1씩 감소하며 반복하는 문법
        if array[j]< array[j-1]:#한 칸씩 왼쪽으로 이동
            array[j],array[j-1] = array[j-1],array[j]
        else:#자기보다 작으면 멈춤
            break
print(array)

#시간복잡도
#삽입 정렬의 시간 복잡도는 O(N^2)이며 선택 정렬과 마찬가지로 2중 반복문
#삽입 정렬은 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작
    #최선의 경우 O(N)의 시간복잡도
