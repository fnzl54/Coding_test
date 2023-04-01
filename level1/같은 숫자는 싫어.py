# https://school.programmers.co.kr/learn/courses/30/lessons/12906
def solution(arr):
    o_anser = [10]
    
    for i in range(len(arr)):
        if o_anser[-1] != arr[i]:
            o_anser.append(arr[i])
    
    answer = o_anser[1:]
    
    return answer