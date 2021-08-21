def solution(s):
    answer = len(s) # 1개 단위로 잘랐을 경우
    length = answer
    check = ''
    
    for i in range(1,length//2+1): #문자열 길이의 반까지만 잘라보면 됨
        count = 0
        num = 1 #문자열 잘랐을 때 그 개수를 세는 변수 
        for j in range(0,length+1,i):
            a = s[j:j+i] #각 단위별로 자른 문자열
            if check == a:
                num += 1
            else:
                check = a #문자가 겹치지 않으면 업데이트
                count += len(a) #자른 문자길이만큼 더해줌
                if num >= 2: #동일한 문자열이 2개이상이면
                    count += len(str(num)) #그 개수를 길이로 바꾸어서 더해줌
                num = 1 #다른 문자열로 바뀌었으니 다시 1로 세팅
                
            
        answer = min(answer,count)
             
        
        
    return answer