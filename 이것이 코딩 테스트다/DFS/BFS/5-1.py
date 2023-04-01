# N x M 크기의 얼음 틀
# 구멍이 뚫린 부분은 0, 칸막이 존재 부분은 1
# 구멍이 뚫린 부분에서 상하좌우가 붙어있으면 연결을 통해 하나라고 생각
from collections import deque

n, m = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

graph = []
for i in range(n):
    graph.append(list(map(int, input())))
    
def bfs(x, y):
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    queue = deque()
    queue.append((x, y))
    
    if graph[x][y] == 0:
        graph[x][y] = 1
        queue = deque()
        queue.append((x, y))
        
        while queue:
            x, y = queue.popleft()
            
            for dir in range(4):
                x   
        
        
        
        return True
    return False
        
    
res = 0
for i in range(n):
    for j in range(m):
        if bfs[i][j] == True:
            res += 1
            
print(1)