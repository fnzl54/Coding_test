# 나이트는 이동시 L자 형태로만 이동이 가능, 정원 밖으로 나갈 수 없음
# 열은 알파벳, 행은 숫자로 들어옴

input_data = input()
row = int(input_data[1])
col = int(ord(input_data[0])) - int(ord('a')) + 1

steps = [(-2,-1), (-1,-2), (1,-2), (2,-1),
         (2,1), (1,2), (-1,2), (-2,1)]

count = 0

for step in steps:
    next_row = row + step[0]
    next_col = col + step[1]
    
    if next_row >= 1 and next_row <= 8 and next_col >= 1 and next_col <= 8:
        count += 1
        
print(count)