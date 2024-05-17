import copy
def rotate_arr():
    new_arr = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            new_arr[j][n - 1 - i] = arr[i][j]

    return new_arr

t = int(input())
for test_case in range(1,t+1):
    print(f"#{test_case}")
    n = int(input())
    arr = [list(map(str,input().split())) for _ in range(n)]
    answer = [[0 for _ in range(3)] for _ in range(n)]
    arr = rotate_arr()
    for i in range(n):
        answer[i][0] = ''.join(arr[i])
    arr = rotate_arr()
    for i in range(n):
        answer[i][1] = ''.join(arr[i])
    arr = rotate_arr()
    for i in range(n):
        answer[i][2] = ''.join(arr[i])
    for ans in answer:
        print(*ans)

