N = int(input())
A = input().split()

x,y = 1,1

dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_type = ['L','R','U','D']

for move in A:
    for i in range(len(move_type)):
        if move == move_type[i]:
            a = x + dx[i]
            b = y + dy[i]
            #파이썬은 a와 b를 초기화하지 않고 여기서 바로 초기화 해도
            #아래의 if문 밖의 다른 if문에서도 사용이 가능하다
            print(a,b)
    if a<1 or b< 1 or a>N or b>N:
        continue

    x,y = a,b
print(a,b)

#이 문제는 요구사항대로 충실히 구현하면 되는 문제
#일련의 명령에 따라서 개체를 차례대로 이동시킨다는 점에서 시뮬레이션 유형으로도 분류되며
# 구현이 중요한 대표적인 문제 유형
#다만 알고리즘 교재나 문제 풀이 사이트에 따라서 다르게 일컬을 수 있으므로 코딩 테스트에서의
#시뮬레이션 유형, 구현 유형, 완전 탐색 유형은 서로 유사한 점이 많다는 정도로만 기억