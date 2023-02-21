# 입력 받은 수를 내림차순으로 정렬
array = []

n = int(input())

for i in range(n):
    array.append(int(input()))

array = sorted(array, reverse=True)

for i in array:
    print(i, end=' ')