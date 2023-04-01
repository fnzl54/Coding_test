# 2개의 배열, n은 각 배열의 원소 갯수, k는 배열 간의 바꿀 수 있는 횟수

n, k = map(int, input().split())
one = list(map(int, input().split()))
two = list(map(int, input().split()))

one.sort()
two.sort(reverse=True)

for i in range(k):
    if one[i] < two[i]:
        one[i], two[i] = two[i], one[i]
    else:
        break
    
res = sum(one)

print(res)
    