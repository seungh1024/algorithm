def solution(number, k):
    answer = ''
    
    data = ['0'] #처음 비교를 위해 넣어줌
    number = list(number)
    number.reverse() #pop 했을시 제일 앞에값 부터 출력되도록 반전시켜줌
    test = []
    
    if len(number) == 1:
        return number[0]
    
    if k == len(number)-1:
        return max(number)
    
    while k > 0: # k가 0 보다 클 동안
        if number == []: #예외처리 -> pop할게 없으면 반복문 탈출
            break
        a = number.pop() #입력값
        while data[-1] < a and len(data)>1: #data에 pop한 것 보다 작은것들 전부 비교
            #자기보다 큰 값을 마주치면 멈춤
            data.pop() #자기보다 작으면 없애버림
            k -= 1 #없앴으니 k줄여줌
            if k == 0 or data == []: #더이상 pop할게 없거나 모두 뺐으면 탈출
                break
        data.append(a) #비교후에 추가해줌
    
    
    for i in range(len(number)): #data에 남은 number를 전부 넣어줌
        data.append(number.pop())
    
    for i in range(1,len(data)): #data값을 모두 더해주면 정답
        answer += data[i]
    
    if k>0: #예외처리 -> 999991,3이 입력되었을 때 k가 0보다 큼
        #뒤에서부터 k만큼 잘라서 리턴해줌
        return answer[:len(number)-k]
    
    return answer