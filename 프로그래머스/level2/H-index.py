def solution(citations):
    answer = 0
    citations.sort() #정렬 -> h번잉용된 논문이 h편 이상인지 확인하려면 정렬 하는게 편함
    
    if citations[0] > len(citations): #길이보다 인용된 횟수가 모두 많으면 길이가 최댓값이니 리턴 -> 예외처리
        return len(citations)
    
    index = 0 #논문의 위치 인덱스
    for i in range(len(citations)+1): #0번 인용부터 n까지 i가 인용횟수임
        # 현재 인용횟수보다 큰 인용횟수의 개수가 현재 인용횟수 이상이고 현재 인용횟수가 현재 논문의 인용횟수보다 같거나 작아야함
        if i <= len(citations) - index and i <= citations[index]: 
            answer = i #우선 h의 조건을 만족하므로 최댓값을 저장 작은값 부터 넣어가니 비교는 필요없음
        else:
            index += 1 #위의 경우가 아니라면 index값을 올려서 h보다 크게 만들어줌 -> 비교를 위해
        
        # if index >= len(citations): #제한사항 때문에 예외처리 필요없음
        #     break
                
    return answer