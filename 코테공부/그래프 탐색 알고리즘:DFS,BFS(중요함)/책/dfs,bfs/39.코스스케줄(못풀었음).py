from collections import defaultdict

#중복 방문하면 순환 -> 순환이면 False

n,m = map(int,input().split())
data = []
for i in range(m):
    data.append(list(map(int,input().split())))

course = defaultdict(list)

for a,b in data:
    course[a].append(b)

check = set() #순환인지 판별 ->중복 값을 갖지 않음
visited = set() #방문한 곳 ->마찬가지로 중복 값을 갖지 않음

def dfs(start):
    if start in check:
        return False #순환구조면 False 리턴

    if start in visited:
        return True #방문했던 곳이면 True 리턴하여 탐색종료

    #for문안에 넣으면 안되는게 위의 순환구조 판별을 거쳐야하기 때문
    check.add(start)

    for i in course[start]: #start에 해당하는 값으로 dfs를 함
        #dfs를 함으로써 해당 키 값에 해당하는 밸류 값을 찾아서 계속 진행함
        if not dfs(i): #False면 False리턴
            return False
    
    check.remove(start)#탐색 종료 후 경로 삭제
    #삭제 해주어야 다른 경로를 탐색하는 중에 충돌이 안생김
    visited.add(start)#탐색 종료 후 경로 추가 -> 방문했던 곳들 저장됨
    
    return True

def fun():
    #여기서 list로 한 번 감싸주는 이유는 에러가 발생함
    #중간에 변경한 적이 없는데 계속 변경했다는 오류가 발생하는 것
    #위의 사전 자료형을 초기화 할때 defaultdict를 사용했는데
    #이는 키가 없는 딕셔너리에 대해서 빈 값 조회시 Null오류가 발생하지 않도록
    #처리한 바가 있는데 여기서 조회시 오류가 생기지 않게 항상 디폴트를 생성해서
    #오류가 생기는 것
    #해당 반복문이 제대로 수행되려면 course변수를 defaultdict에서 분리해서
    #고정시킬 필요가 있는데 이 때 파이썬 2,3의 해결방법이 다르며
    #파이썬 3의 방법으로는 list()로 묶어서 새로운 복사본을 만들어 해결하는 것이다
    for i in list(course):
        #키 값으로만 dfs를 호출하여 순환 구조를 판별함
        print(i)
        if not dfs(i):
            return False
    return True

if not fun():
    print('False')
else:
    print('True')
print(course)