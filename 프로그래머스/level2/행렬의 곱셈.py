def solution(arr1, arr2):
    answer = []
    data = []
    for i in range(len(arr2[0])): #데이터 초기화 -> arr2와 같은 크기로 만들어줌
        data.append([0]*len(arr2))
        
    for i in range(len(arr2)):#편하게 곱해주기 위해서 행과 열을 바꿔줌
        for j in range(len(arr2[0])):
            data[j][i] = arr2[i][j]
    print(data)
    
    for i in range(len(arr1)): #arr1의 행 데이터
        a = []
        for j in range(len(data)): #data의 각 행을 곱해줘야 하므로 반복
            b = 0
            for k in range(len(arr1[i])): #각각의 원소들으 곱해서 더해주기 위해 반복
                b += arr1[i][k] * data[j][k]
            a.append(b)
        answer.append(a)
        
        
    return answer