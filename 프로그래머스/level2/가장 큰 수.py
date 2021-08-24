def solution(numbers):
    answer = ''
    data = []
    for i in numbers:  #1000이하라서 4자리로 전부 맞춰주고 맨 마지막은 자기자신을 넣음
        if i == 0:
            data.append((-1,0))
        elif i < 10:
            data.append((i,i,i,i,i)) 
        elif i < 100:
            data.append((i//10,i%10,i//10,i%10,i)) 
        elif i < 1000:
            data.append((i//100,(i%100)//10,(i%100)%10,i//100,i)) 
        else:
            data.append((0,0,0,0,i))
    
    data.sort(reverse = True) #값이 큰것부터니 reverse
    # print(data)
    
    if data[0][-1] ==0 and data[-1][-1] == 0: #0만 있는경우
        return "0"
    
    for i in data:
        answer+= str(i[-1])
            
        
    return answer