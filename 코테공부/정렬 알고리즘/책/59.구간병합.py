import time
n = int(input())
data = []
for i in range(n):
    data.append(list(map(int,input().split())))
start = time.time()

data.sort()
# print(data)
# a = data[0]
# data.remove(a)
# print(data)

result = []
save = data[0][0]
print(save)
# for i in range(1,len(data)-1):
#     print(i)
#     if data[i][0] > data[i-1][1]:
#         data[i][0] = save
#         save = data[i][1]
#         data.remove(data[i-1])
i = 1
while True:
    if i >= len(data):
        break
    if data[i][0] < data[i-1][1]:
        data[i][0] = save
        save = data[i-1][0]
        data.remove(data[i-1])
        i -=1
    i += 1

end = time.time()

print(data)
print(end-start)