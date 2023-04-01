# N이 1이 될 때까지 두 과정 중 하나를 반복
# 1. N에서 1을 뺸다
# 2. N을 K로 나눈다

n, k = map(int, input().split())
count  = 0

while (n != 1):
    if (n % k == 0):
        n /= k
        count += 1
    else:
        n -= 1
        count += 1

print(count)