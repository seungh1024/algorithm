start = list(input())

row = [2,2,-2,-2,1,-1,1,-1]
col = [1,-1,1,-1,2,2,-2,-2]
colnum = ['a','b','c','d','e','f','g','h']
startstring = start[0]

for i in range(len(colnum)):
    if colnum[i] == startstring:
        x=i+1
        y=int(start[1])
        print(x,y)
        break
count = 0
for i in range(8):
    if x + row[i] >=1 and x + row[i]<=8:
        if y+ col[i] >=1  and y + col[i] <=8:
            count +=1

print(count)

#모범 답안
#문제 해결 아이디어
#-요구사항대로 충실히 구현하면 되는 문제
#-나이트의 8가지 경로를 하나씩 확인하며 각 위치로 이동이 가능한지 확인함
#   ->리스트를 이용하여 8가지 방향에 대한 방향 벡터를 정의함

#현재 나이트의 위치 입력받기
input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0])) - int(ord('a'))+1
#ord(문자) -> 아스키 코드를 반환해 준다
#chr(숫자) -> 숫자에 맞는 아스키 코드를 반환한다.

#나이트가 이동할 수 있는 8가지 방향 정의
steps = [(-2,-1),(-1,-2),(1,-2),(2,-1),(2,1),(1,2),(-1,2),(-2,1)]
#나처럼 두 개의 리스트를 만들지 않고 하나의 방향 벡터로 정의함

#8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
result = 0
for step in steps:
    #이동하고자 하는 위치 확인
    next_row = row + step[0]
    next_column = column + step[1]
    #해당 위치로 이동이 가능하다면 카운트 증가
    if next_row >= 1 and next_row <=8 and next_column >=1 and next_column <=8:
        result += 1
print(result)