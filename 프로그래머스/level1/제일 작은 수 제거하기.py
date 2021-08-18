def solution(arr):
    a = sorted(arr,reverse = True)[-1]
    arr.remove(a)
    # arr.remove(min(arr))
    # sorted 쓸 필요없이 min 쓰면됨

    if arr == []:
        return [-1]
    
    return arr
