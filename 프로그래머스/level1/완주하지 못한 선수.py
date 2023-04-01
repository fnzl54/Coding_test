#https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=python3
from collections import Counter

def solution(participant, completion):
    answer = ''
    
    p_dict = Counter(participant)
    c_dict = Counter(completion)
    
    answer = list((p_dict - c_dict).keys())[0]
    
    return answer