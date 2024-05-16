import copy
n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

while len(arr)>1:
    len_ = len(arr)
    new_arr = [[0 for _ in range(len_//2)] for _ in range(len_//2)]
    for i in range(len_//2):
        for j in range(len_//2):
            tmp = []
            for x in range(i*2,i*2+2):
                for y in range(j*2,j*2+2):
                    tmp.append(arr[x][y])
            tmp.sort()
            new_arr[i][j] = tmp[-2]
    arr = copy.deepcopy(new_arr)

print(arr[0][0])