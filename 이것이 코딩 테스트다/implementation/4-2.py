# 정수 N이 입력되면 00:00:00 부터 N:59:59 시각 중 3이 하나라도 포함되는 경우
n = int(input())

count = 0

for i in range(n+1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                count += 1
                
print(count)