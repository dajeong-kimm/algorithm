import sys
input = sys.stdin.readline
sys.maxsize

def minimal_board(color):
    prefix_sum = [[0]*(m+1) for _ in range(n+1)]
    for i in range(n):
        for j in range(m):
            if (i+j)%2 == 0:
                value = (board[i][j] != color)
            else:
                value = (board[i][j] == color)
            prefix_sum[i+1][j+1] = prefix_sum[i][j+1] + prefix_sum[i+1][j] - prefix_sum[i][j] + value

    count = sys.maxsize
    for i in range(1,n-k+2):
        for j in range(1,m-k+2):
            answer1 = prefix_sum[i+k-1][j+k-1]-prefix_sum[i+k-1][j-1]-prefix_sum[i-1][j+k-1]+prefix_sum[i-1][j-1]
            count = min(count,answer1)
    return count


n,m,k = map(int,input().split())
board = [list(input()) for _ in range(n)]
print(min(minimal_board('B'),minimal_board('W')))
