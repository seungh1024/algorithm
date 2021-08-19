def solution(arr, divisor):
    answer = []
    
    if divisor == 1:
        return sorted(arr)
    
    for i in arr:
        if i % divisor == 0:
            answer.append(i)
    
    if answer == []:
        return [-1]

    return sorted(answer)
    