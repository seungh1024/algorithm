import math
import heapq

n,k = map(int,(input().split()))
points = []
for i in range(n):
    points.append(list(map(int,input().split())))

Q = []
i = 0
for a,b in points:
    # data[i]=a*a+b*b
    heapq.heappush(Q,(a*a+b*b,i))
    i += 1

print(Q)
result = []
for i in range(k):
    result.append(points[heapq.heappop(Q)[1]])

print(result)
