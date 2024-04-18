n,l = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(n)]

def check(line,l):
    visited = [False for _ in range(n)]

    for i in range(0,n-1):
        if line[i] == line[i+1]:
            continue
        elif abs(line[i]-line[i+1])>1:
            return False
        elif line[i]>line[i+1]:
            temp = line[i+1]
            for j in range(i+1,i+l+1):
                if 0<=j<n:
                    if temp != line[j]:
                        return False
                    elif visited[j]:
                        return False
                    visited[j] = True
                else:
                    return False
        else:
            temp = line[i]
            for j in range(i,i-l,-1):
                if 0<=j<n:
                    if temp != line[j]:
                        return False
                    elif visited[j]:
                        return False
                    visited[j] = True
                else:
                    return False
    return True

answer = 0

for i in range(n):
    if check(board[i],l):
        answer += 1

for i in range(n):
    tmp = []
    for j in range(n):
        tmp.append(board[j][i])
    if check(tmp,l):
        answer += 1

print(answer)

