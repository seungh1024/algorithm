from collections import deque,defaultdict
#defaultdict는 사전 자료형의 디폴트 값을 정할 수 있게 함

n = int(input())
data = []
for i in range(n):
    data.append(list(map(str,input().split())))

# ticket = dict()
ticket = defaultdict(list) #리스트 형으로 값을 초기화 한 것

for a,b in sorted(data): #나중에 알았는데 sorted(data,reverse=True)
    #이게 가능함 역순으로 하면 pop(0)를 안하고 pop()을 했을 것임
    ticket[a].append(b) 
print(ticket)

result = []
def bfs(start):
    result.append(start)
    while ticket[start]:
        bfs(ticket[start].pop(0)) 
    # result.append(start)

#큐를 사용하려 했는데 굳이 사용안해도 됐고 잘 안됐음
#정렬된 티켓에서 바로 추출하여 결과값에 넣어줬음
bfs('jfk')
print(result)