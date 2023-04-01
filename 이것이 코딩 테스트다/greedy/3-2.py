# N (주어질 자연수의 갯수), M(더해질 횟수) ,K(한 숫자를 최대 연속하여 더해질 횟수)

n, m, k = map(int, input().split())
data = list(map(int, input().split()))
result = 0
count = 0

data.sort(reverse=True)

for i in range(m):
    if count == k:
        result += data[1]
        count = 0
    else :
        result += data[0]
    count += 1
    
print(result)