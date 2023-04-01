# 숫자 키드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한장을 뽑는 게임
# N은 행의 수, M은 열의 수
# 1. 뽑고자하는 카드가 포함되어 있는 행 선택
# 2. 선택된 행에 포함된 카드 중에서 가장 숫자가 낮은 카드 뽑기
# 3. 위의 과정에서 가장 큰 수 찾기

n, m = map(int, input().split())
result = 0

for i in range(n):
    data = list(map(int, input().split()))
    min_value = min(data)
    
    result = max(result, min_value)
    
print(result)