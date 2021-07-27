n,m = map(int,input().split())

ricecake = list(map(int,input().split()))
ricecake.sort(reverse = True)

# print(n,m,ricecake)

def fun(start,end):
    count = 0
    mid = (end + start)//2
    if start >= end:
        return mid
    for i in range(len(ricecake)):
        cut = ricecake[i] - mid
        # print(cut)
        if cut >= 0:
            count += cut
    # print(mid,end)
    # print(count)
    if count == m:
        return mid
    elif count >m:
        return fun(mid+1,end)

    else:
        return fun(start,mid-1)
    #mid 값을 각각 +1,-1을 잘 해줘야 함
    #해주지 않으면 무한 재귀가 됨
    #제일 첫 if문에서 count 와 m이 같은지 비교하므로
    #각각 1큰값과 1작은값으로 넣어서 함수호출을 해야함
        
# result = fun(0,ricecake[0])
# if result == None:
#     print('해당 길이로 자를 수 없습니다')
# else:
#     print(result)
print(fun(0,ricecake[0]))