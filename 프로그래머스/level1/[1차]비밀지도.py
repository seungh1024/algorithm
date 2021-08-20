def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        x = ''
        a = arr1[i]
        b = arr2[i]
        for j in range(n):
            if ((a%2) or (b%2)):
                x = '#' + x
            else:
                x = ' ' + x
            a = a//2
            b = b//2
        answer.append(x)
        
    
    return answer