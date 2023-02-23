# 부품 n개 존재, m개의 부품을 구매

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None
    

n = int(input())
haveItem = list(map(int, input().split()))
m = int(input())
buyItem = list(map(int, input().split()))

haveItem.sort()

for i in buyItem:
    res = binary_search(haveItem, i, 0, n-1)
    
    if res != None:
        print('no', end=' ')
    else:
        print('yes', end=' ')