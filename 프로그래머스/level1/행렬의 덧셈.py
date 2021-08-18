def solution(arr1, arr2):
    answer = []

    for i in range(len(arr1)):
        data = []
        for j in range(len(arr1[i])):
            data.append(arr1[i][j]+arr2[i][j])
        answer.append(data)
        
    return answer