def solution(numbers, hand):
    answer = ''
    #각 번호의 위치를 좌표화
    dict = {0:(3,1),1:(0,0),2:(0,1),3:(0,2),4:(1,0),5:(1,1),6:(1,2),7:(2,0),8:(2,1),9:(2,2)}
    
    
    
    left = (3,0)
    right = (3,2)
    for i in numbers:
        if i == 1 or i ==  4 or i == 7:
            answer += 'L'
            left = dict[i]
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            right = dict[i]
        else:
            #절댓값으로 거리 계산
            leftlen = abs(left[0]-dict[i][0]) + abs(left[1]-dict[i][1])
            rightlen = abs(right[0]-dict[i][0]) + abs(right[1]-dict[i][1])
            if leftlen > rightlen: #오른손이 더 가까우면
                answer += 'R'
                right = dict[i]
            elif leftlen < rightlen: #왼손이 더 가까우면
                answer += 'L'
                left = dict[i]
            else: #두 길이가 같으면
                if hand == 'right': #오른손잡이면 'R', 왼손잡이면 'L'
                    answer += 'R'
                    right = dict[i]
                else:
                    answer += 'L'
                    left = dict[i]
                
            
    return answer