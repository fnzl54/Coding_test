# 거스름돈 500, 100, 50, 10
# n원을 거슬러 줘야 할 때 최소 개수

n = int(input())
count = 0

list = [500, 100, 50, 10]

for i in range(4):
    coin_count = n // list[i]
    n -= list[i] * coin_count
    count += coin_count
    
print(count)