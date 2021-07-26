n = str(input())

data = {'2':'abc','3':'def','4':'ghi','5':'jkl','6':'mno','7':'pqrs',
        '8':'tuv','9':'wxyz'        
}
print(data["2"][0])

result = []

def dfs(num,length,word):
    #재귀호출을 하다가 마지막 자식 노드에 도착하면 결과에 추가하고 종료시킴
    if length == len(n):
        result.append(word)
        return

    #각 인덱스의 길이별로 dfs를 재귀호출함
    #재귀호출 함으로써 트리구조로 생각했을 때 자식 노드의 첫 번째로 가서 다시 재귀호출을 함
    for i in data[n[num]]:
        dfs(num+1,length+1,word+i)
    
    #각각의 재귀호출된 함수가 종료되면 완성된 단어들이 result에 있을 것임
    #왼쪽에서부터 차례대로 탐색했기 떄문임
    
dfs(0,0,"")#0에서 시작 길이도 0으로 줌
print(result)
print(len(result))