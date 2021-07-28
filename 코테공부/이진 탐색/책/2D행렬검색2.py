from bisect import bisect_left
n = int(input())

data = []
for i in range(n):
    data.append(list(map(int,input().split())))
target = int(input())

def search():
    for i in range(len(data)):
        if data[i][len(data[i])-1] > target:
            a = bisect_left(data[i],target)
            if data[i][a] == target:
                return 'true'
    return 'false'

print(search())
    
#책은 맨 위 오른쪽끝에서 시작하여 타겟이 해당 값보다 작으면 왼쪽으로 크면 아래로 이동
def searchMatrix(matrix,target):
    #예외 처리
    if not matrix:
        return False

    #첫 행의 맨 뒤
    row = 0
    col = len(matrix[0]) -1

    while row <= len(matrix)-1 and col >=0:
        if target == matrix[row][col]:
            return True
        #타겟이 작으면 왼쪽으로 이동
        elif target < matrix[row][col]:
            col -=1
        #타겟이 크면 아래로 이동
        elif target > matrix[row][col]:
            row +=1
    return False

print(searchMatrix(data,target))