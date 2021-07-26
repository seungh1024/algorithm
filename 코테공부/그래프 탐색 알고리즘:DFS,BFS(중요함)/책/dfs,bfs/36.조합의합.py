data = list(map(int,input().split()))
target = int(input())

print(data,target)

result = []
def dfs(com,index,count):
    if count == target:
        result.append(com)
        return
    elif count > target:
        return
    for i in range(index,len(data)):
        dfs(com+[data[i]],i,count+data[i])
#나는 for문의 범위를 항상 0부터 시작했는데
#여기선 중복으로 선택하니 앞에서 탐색을 마친 수를 뒤에서 다시 같이 탐색하니
#계속 중복된 값이 나온 것
#이렇게 index로 앞의 data는 탐색하지 않고 자신을 기준으로
#자신보다 큰 인덱스를 탐색함으로써 중복값이 생기지 않게 함
#이미 앞의 인덱스에서 뒤의 인덱스도 포함하여 탐색을 했기 때문임

dfs([],0,0)

print(result)