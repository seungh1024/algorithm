from bisect import bisect_left

nums = list(map(int,input().split()))
target = int(input())

print(bisect_left(nums,target)) #bisect를 이용한 방법

def binary(start,end): #start,end는 인덱스 값을 줘야함
    if start>end:
        return
    mid = (start+end) // 2

    if nums[mid] == target:
        return mid
    elif nums[mid] > target: #타겟이 작으면 start와 mid사이로 재귀호출
        return binary(start,mid+1)
    else: #타겟이 크면 mid와 end로 재귀호출
        return binary(mid-1,end) 

print(binary(0,len(nums)))