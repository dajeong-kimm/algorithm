from collections import deque

dl = [1, -1, 0, 0, 0, 0]
dr = [0, 0, 1, -1, 0, 0]
dc = [0, 0, 0, 0, 1, -1]

def bfs(i, j, k):
    visited = [[[ -1 for _ in range(c)] for _ in range(r)] for _ in range(l)]
    queue = deque()
    queue.append([i, j, k])
    visited[i][j][k] = 0
    while queue:
        x, y, z = queue.popleft()
        if x == end_pos[0] and y == end_pos[1] and z == end_pos[2]:
            return visited[x][y][z]
        for idx in range(6):
            nx, ny, nz = x + dl[idx], y + dr[idx], z + dc[idx]
            if 0 <= nx < l and 0 <= ny < r and 0 <= nz < c:
                if visited[nx][ny][nz] == -1 and board[nx][ny][nz] != "#":
                    visited[nx][ny][nz] = visited[x][y][z] + 1
                    queue.append([nx, ny, nz])
    else:
        return -1

while True:
    l, r, c = map(int, input().split())
    if (l, r, c) == (0, 0, 0):
        break
    board = []
    for i in range(l):
        tmp = []
        for j in range(r):
            tmp.append(list(input()))
            for k in range(c):
                if tmp[j][k] == "S":
                    start_pos = [i, j, k]
                elif tmp[j][k] == "E":
                    end_pos = [i, j, k]
        xxx = input()  # 해당 줄의 입력을 소비하지 않고 있습니다. 필요한 부분인지 확인해보세요.
        board.append(tmp)
    i, j, k = start_pos
    answer = bfs(i, j, k)
    if answer == -1:
        print("Trapped!")
    else:
        print(f"Escaped in {answer} minute(s).")
