# https://school.programmers.co.kr/learn/courses/30/lessons/1845
def solution(nums):
    o_nums_size = len(nums)
    answer = o_nums_size // 2 if o_nums_size / 2 < len(set(nums)) else len(set(nums))
    return answer