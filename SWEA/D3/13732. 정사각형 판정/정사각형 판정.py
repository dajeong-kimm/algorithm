def check(i,j):
    global hash
    cnt = 1

    for x in range(j+1,n):
        if arr[i][x] == "#":
            cnt += 1
        else:
            break
    if cnt == 1 and hash>1:
        return False
    for x in range(i+1,i+cnt):
        for y in range(j,j+cnt):
            if not(0<=x<n and 0<=y<n):
                return False
            if arr[x][y] == ".":
                return False
    if hash==cnt*cnt:
        return True
    return False


t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]

    hash = 0
    for a in arr:
        hash += a.count("#")

    answer = "no"
    for i in range(n):
        for j in range(n):
            if arr[i][j] == "#":
                if check(i,j):
                    answer = "yes"
                    break
    print(f"#{test_case} {answer}")