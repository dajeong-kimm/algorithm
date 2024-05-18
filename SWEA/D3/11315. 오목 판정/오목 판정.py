def check(i, j):
    dx = [-1, -1, -1, 0, 1, 1, 1, 0]
    dy = [-1, 0, 1, 1, 1, 0, -1, -1]
    for x in range(8):
        cnt = 0
        d_x = dx[x]
        d_y = dy[x]
        nx, ny = i, j
        while True:
            nx += d_x
            ny += d_y
            if not (0 <= nx < n and 0 <= ny < n):
                break
            else:
                if arr[nx][ny] == "o":
                    cnt += 1
                else:
                    break
        if cnt == 4:
            return True
    return False


t = int(input())
for test_case in range(1, t + 1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    answer = "NO"
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 'o':
                if check(i, j):
                    answer = "YES"
                    break
    print(f"#{test_case} {answer}")
