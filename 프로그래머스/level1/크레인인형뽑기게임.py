def solution(board, moves):
    from collections import defaultdict
    from collections import deque
    dict = defaultdict(list)
    
    lenboard = len(board)
    for i in range(lenboard):
        j=lenboard-1 #길이니까 인덱스는 -1
        while board[j][i] != 0 and j >=0:
            dict[i+1].append(board[j][i])
            j -= 1 #뒤에서부터 추가해주기 떄문에 -1
    
    answer = 0
    a = [0]
    for i in moves:
        if dict[i] != []:
            x = dict[i].pop()
            y = a.pop()
            
            if y == x:
                answer +=2
            else:
                a.append(y)
                a.append(x)
            
    return answer