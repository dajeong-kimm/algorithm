import copy
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

answer = 0
def left(board):
    for i in range(n):
        cursor = 0
        for j in range(1,n):
            if board[i][j] != 0:
                tmp = board[i][j]
                board[i][j] = 0

                if board[i][cursor] == 0:
                    board[i][cursor] = tmp
                elif board[i][cursor] == tmp:
                    board[i][cursor] *= 2
                    cursor += 1
                else: # 비어 있지도 않고 다른 값일때
                    cursor += 1
                    board[i][cursor] = tmp # 바로 옆에 붙임
    return board

def right(board):
    for i in range(n):
        cursor = n-1
        for j in range(n-1,-1,-1):
            if board[i][j] != 0:
                tmp = board[i][j]
                board[i][j] = 0

                if board[i][cursor] == 0:
                    board[i][cursor] = tmp
                
                elif board[i][cursor] == tmp:
                    board[i][cursor] *= 2
                    cursor -=1
                else:
                    cursor -=1
                    board[i][cursor] = tmp
    return board

def up(board):
    for j in range(n):
        cursor = 0
        for i in range(n):
            if board[i][j] != 0:
                tmp = board[i][j]
                board[i][j] = 0

                if board[cursor][j] == 0:
                    board[cursor][j] = tmp
                
                elif board[cursor][j] == tmp:
                    board[cursor][j] *= 2
                    cursor += 1
                
                else:
                    cursor += 1
                    board[cursor][j] = tmp
    return board

def down(board):
    for j in range(n):
        cursor = n-1
        for i in range(n-1,-1,-1):
            if board[i][j] != 0:
                tmp = board[i][j]
                board[i][j] = 0

                if board[cursor][j] == 0:
                    board[cursor][j] = tmp

                elif board[cursor][j] == tmp:
                    board[cursor][j] *= 2
                    cursor -= 1

                else:
                    cursor -= 1
                    board[cursor][j] = tmp
    return board





def dfs(arr,cnt):
    global answer
    if cnt == 5:
        tmp = 0
        for a in arr:
            tmp = max(tmp,max(a))
        answer = max(answer,tmp)
        return
    
    for i in range(4):
        copy_arr = copy.deepcopy(arr)
        if i==0:
            dfs(left(copy_arr),cnt+1)
        elif i==1:
            dfs(right(copy_arr),cnt+1)
        elif i==2:
            dfs(up(copy_arr),cnt+1)
        else:
            dfs(down(copy_arr),cnt+1)

# if n == 1:
#     print(arr[0][0])
#     exit()

dfs(arr,0)
print(answer)