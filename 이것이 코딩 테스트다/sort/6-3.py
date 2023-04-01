# 성적을 입력 받아서 성적이 낮은 순서로 출력

array = []
n = int(input())

for i in range(n):
    input_data = input().split()
    array.append((input_data[0], int(input_data[1])))

# 키(Key)를 이용하여, 점수를 기준으로 정렬
array = sorted(array, key=lambda sortarr: sortarr[1])

for sortarr in array:
    print(sortarr[0], end=' ')