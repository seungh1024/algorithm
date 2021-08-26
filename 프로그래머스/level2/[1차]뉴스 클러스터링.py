def solution(str1, str2):
    answer = 0
    str1 = str1.upper()
    str2 = str2.upper()
    if str1 == str2:
        return 65536
    
    case1 = [] #str1 문자열 담을 리스트
    case2 = [] #str2 문자열 담을 리스트
    for i in range(len(str1)-1):
        if ord(str1[i]) >=65 and ord(str1[i]) <= 90 and ord(str1[i+1]) >=65 and ord(str1[i+1]) <= 90:
            case1.append(str1[i]+str1[i+1])
    
    for i in range(len(str2)-1):
        if ord(str2[i]) >=65 and ord(str2[i]) <= 90 and ord(str2[i+1]) >=65 and ord(str2[i+1]) <= 90:
            case2.append(str2[i]+str2[i+1])
    
    case1.sort()
    case2.sort()
    i = 0
    j = 0
    both = 0 #교집합 세는 것 합집합은 두 리스트 길이 합해서 교집합만 빼면 됨
    while True:
        if i > len(case1)-1 or j > len(case2)-1:
            break
        if case1[i] == case2[j]:
            both += 1
            i+=1
            j+=1
        elif case1[i] < case2[j]:
            i += 1
        else:
            j += 1
        
    jakade = both/(len(case1)+len(case2)-both)
    
        
    return int(jakade*65536)

