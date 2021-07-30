n = int(input())
k = list(map(int,input().split()))

count = 0 #약탈한 총 식량
index = 0 #0일 때 둘중에 앞의 값을 추가 1일 때 뒤에 값을 추가
i = 2
while True:
    if i >= len(k)-1:
        if index == 0:
            if k[len(k)-1] >= k[len(k)-2]:
                count += k[len(k)-1]
            else:
                count += k[len(k)-2]
        else:
            count += k[len(k)-1]
        break
    if k[i] > k[i-1] + k[i-2]:
        count += k[i-2]
        index = 0
        i += 2
    elif k[i] <= k[i-1] + k[i-2]:
        if k[i-1] > k[i-2]:
            count +=k[i-1]
            i +=3
            index = 1
        else:
            count +=k[i-2]
            i += 2
            index = 0
    
print(count)