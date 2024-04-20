from collections import deque
# k세대 드래곤 커브는 k-1세대 드래곤 커브를 끝 점을 기준으로
# 90도 시계 방향 회전 시킨 다음, 그것을 끝 점에 붙인 것

# 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 개수?
def dragon_curve(x,y,d,g):
    # queue = deque()
    # 0 우 1 상 2 좌 3 하
    dir = [(0,1),(-1,0),(0,-1),(1,0)]
    board[x][y] = 1

    curve = [d]
    for j in range(g):
        for k in range(len(curve)-1,-1,-1):
            curve.append((curve[k]+1)%4)
    
    for j in range(len(curve)):
        x += dir[curve[j]][0]
        y += dir[curve[j]][1]
        board[x][y] = 1

    # board[x][y] = 1
    # queue.append(d)
    # nx,ny = x+dir[d][0], y+dir[d][1]
    # board[nx][ny] = 1
    # for i in range(g):
    #     memory = []
    #     for j in range(len(queue)):
    #         tmp = queue.pop()
    #         cur = (tmp+1)%4
    #         queue.appendleft(tmp)
    #         nx,ny = x+dir[cur][0],y+dir[cur][1]
    #         board[nx][ny] = 1
    #         memory.append(cur)
    #         x,y = nx,ny
    #     for m in memory:
    #         queue.append(m)
    #     print(memory)
            
def count_square(board):
    result = 0
    for i in range(100):
        for j in range(100):
            if board[i][j] == 1:
                if board[i][j+1] == 1 and board[i+1][j] == 1 and board[i+1][j+1] == 1:
                    result += 1
    return result

n  = int(input())
board = [[0]*101 for _ in range(101)]
for _ in range(n):
    y,x,d,g = map(int,input().split(' '))
    dragon_curve(x,y,d,g)
print(count_square(board))

# test = 0
# for i in range(101):
#     for j in range(101):
#         if board[i][j] == 1:
#             print(i,j)


