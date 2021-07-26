from collections import defaultdict
import heapq #heapq를 쓰기위한 모듈
#내부적으로 가장 작은 값이 인덱스0에 위치하게 됨
#이진트리 방식임

a = int(input())
times = []
for i in range(a):
    times.append(list(map(int,input().split())))
# print(times)

n,k = map(int,input().split())
print(n,k)

data = defaultdict(list)

for a,b,c in times:
    data[a].append((b,c))

print(data)

Q = [(0,k)]#우선순위 큐를 사용하기 위한 변수
#큐 변수 Q는 (소요시간,정점) 구조로 구성함
#시작점에서 정점까지의 소요 시간을 담아둘 것
#시간이 적은 것 부터 pop으로 나오게 됨
dist = defaultdict(int)
#거리를 의미하는 변수

while Q:
    time,node = heapq.heappop(Q)
    print(node)
    if node not in dist:
        dist[node] = time
        for v,w in data[node]:
            alt = time + w
            heapq.heappush(Q,(alt,v))

if len(dist) == n:
    print(max(dist.values()))
else:
    print(-1)