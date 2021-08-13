def solution(participant, completion):
    from collections import defaultdict
    
    data = defaultdict(int)
    
    for i in completion:
        data[i] += 1
    
    for i in participant:
        if data[i] == 0:
            return i
        else:
            data[i] -= 1