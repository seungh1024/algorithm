def solution(s):
    answer = ''
    data = list(map(int,s.split()))
    return f'{min(data)} {max(data)}'