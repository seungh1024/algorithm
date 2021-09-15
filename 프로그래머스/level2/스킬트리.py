def solution(skill, skill_trees):
    answer = 0
    for i in skill_trees:
        index = 0 #스킬의 인덱스
        a = 0 #skill에 해당되는지 확인하기 위한 변수
        check = 0 #선행 스킬과 관련되지 않은 스킬로만 구성된 것을 구분하기 위함
        for j in i: #스킬 트리중에서
            if j in skill: #스킬들 중에 하나
                if j != skill[index]: #스킬순서가 위배되면
                    a = 0 # ''로 초기화 해서 카운트 되지 않게
                    break #뒤에는 볼 필요 없으니 break
                else: #스킬 순서가 알맞으면
                    a = 1 # 카운트 하기위해 a를 1로 바꾸어줌
                    index += 1 #skill의 인덱스를 올려줌
            else: #스킬에 해당되지 않는 스킬이면
                check += 1 
            
        if a == 1 or check == len(i): #스킬 순서가 위배되지 않거나 모든 스킬이 선행 스킬순서와 상관없으면 +1
            answer += 1
            
    return answer