from collections import defaultdict,deque

a = int(input())
times = []
for i in range(a):
    times.append(list(map(int,input().split())))
# print(times)

n,k = map(int,input().split())
print(n,k)

data = defaultdict(list)
check = set() #모든 노드가 방문하는지를 알기 위함

for a,b,c in times:
    for i in range(c-1):
        data[b].append(b)
    data[a].append(b)

print(data)


count = set() #최대 시간을 구하기 위함
def dfs(start,length):
    count.add(length) #길이를 set에 계속 넣음으로써 중첩안되게 했음
    #마지막에 count의 길이에서 -1을 한 것이 모든 노드가 받는 시간임(0때문에 뺌)
    check.add(start)
    #방문한 것은 중복안되게 넣음
    if not data[start]:
        del data[start]
        return 
        
    for i in range(len(data[start])):
        if not data[start]:
            return
        a = data[start][0]
        del data[start][0]
        dfs(a,length+1)
    

dfs(k,0)
if len(check)<n: #모두 방문하지 않으면 -1을 출력하도록
    print(-1) 
else:
    print(len(count)-1)   