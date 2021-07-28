nums = list(map(int,input().split()))
target = int(input())

data = sorted(nums)
data.sort()
for i in range(len(nums)):
    if data[0] == nums[i]:
        pivot = i
        break
print(pivot)
start = 0
end = len(data)
while True:
    if start > end:
        break
    mid = (start+end) // 2

    if data[mid] == target:
        print(pivot + mid)
        break
    elif data[mid] > target:
        end = mid + 1
    else:
        start = mid - 1