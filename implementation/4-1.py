# 공간의 크기를 나타내는 N
# 계획은 입력으로 줌
# 츨력은 X, Y 좌표를 구분하여 출력

n = int(input()) # 5
plans = input().split() # R R R U D D
x, y = 1, 1 

# L R U D
steps = [ (0, -1), (0, 1), (-1, 0), (1, 0)]
move = ['L', 'R', 'U', 'D']

for plan in plans:
    next_x = x + steps[move.index(plan)][0]
    next_y = y + steps[move.index(plan)][1]
    
    if next_x < 1 or next_y < 1 or next_x > n or next_y > n:
        continue
    
    x, y = next_x, next_y
    
print(x, y) 
    