from collections import deque
def coord(num):
    if num%10 == 0:
        i = num//10-1
        j = 9
    else:
        i = num//10
        j = num%10-1
    return i,j

n,m = map(int,input().split())
n_list = {}
m_list = {}

for _ in range(n):
    a,b = map(int,input().split())
    n_list[a] = b

for _ in range(m):
    a,b = map(int,input().split())
    m_list[a] = b


def bfs():
    visited = [[0]*10 for _ in range(10)]
    cnt = [[0]*10 for _ in range(10)]
    queue = deque()
    queue.append((0,0,1))
    visited[0][0] = 1
    while queue:
        x,y,num = queue.popleft()
        for i in range(1,7):
            new_num = num + i
            if new_num in n_list:
                a,b = coord(new_num)
                visited[a][b] = 1
                new_num = n_list[new_num]
            if new_num in m_list:
                a,b = coord(new_num)
                visited[a][b] = 1
                new_num = m_list[new_num]
            nx,ny = coord(new_num)
            if 0<=nx<10 and 0<=ny<10 and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                cnt[nx][ny] = cnt[x][y] +1
                queue.append((nx,ny,new_num))

    return cnt[9][9]

print(bfs())





