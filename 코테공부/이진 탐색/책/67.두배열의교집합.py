from bisect import bisect_left

nums1 = list(map(int,input().split()))
nums2 = list(map(int,input().split()))

a = set(nums1)
b = set(nums2)
print(a,b)

print(list(a & b))

#이진탐색 풀이
nums1 = list(map(int,input().split()))
nums2 = list(map(int,input().split()))

nums1.sort()
result = set()
for i in nums1:
    a = bisect_left(nums2,i)
    if nums2[a] == i:
        result.add(i)
print(list(result))