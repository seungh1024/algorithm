answer = 0

def solution(numbers, target):
    def dfs(num,index):
        global answer
        # print(num,index,answer)
        if index == len(numbers):
            if num == target:
                answer += 1
            return
        dfs(num+numbers[index],index+1)
        dfs(num-numbers[index],index+1)
        
    dfs(0,0)
    
    return answer