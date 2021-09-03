from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    c = 0 #다리위 차량의 수
    w = 0 #다리위 차량 무게 합
    data = deque([0]*bridge_length) #트럭 위치를 알기 위함
    
    for truck in truck_weights:
        if w+truck <= weight:
            a = data.popleft()
            if a > 0:
                w -= a
            data.append(truck)
            # print('small:',data)
            w += truck
            answer += 1
        elif w+truck > weight:
            while True:
                a = data.popleft()
                if a > 0:
                    w -= a
                if w+truck <= weight:
                    data.append(truck)
                    w += truck
                    answer += 1
                    # print('full:',data)
                    break
                else:
                    data.append(0)
                    answer += 1
                    # print('full:',data)
                
        
    answer += bridge_length
    return answer