from bisect import bisect_left
import time
numbers = list(map(int,input().split()))
target = int(input())

start = time.time()
index = bisect_left(numbers,target)

result =[]
for i in range(index):
    # for j in range(1,index):
    #     if numbers[i]+numbers[j] == target:
    #         result.append(i+1)
    #         result.append(j+1)
    expected = target - numbers[i]
    a = bisect_left(numbers,expected)
    if numbers[a] + numbers[i] == target:
        print([i+1,a+1])
        break
print(result)
end = time.time()
print(end-start)

start = time.time()
#책 답안
for i in range(len(numbers)):
    expected = target - numbers[i]
    a = bisect_left(numbers,expected)
    if numbers[a] + numbers[i] == target:
        print([i+1,a+1])
        break
end = time.time()
print(end-start)