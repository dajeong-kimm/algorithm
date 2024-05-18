t = int(input())

for test_case in range(1,t+1):
    n,k = map(int,input().split())
    arr =[list(map(int,input().split())) for _ in range(n)]
    answer = 0

    for i in range(n):
        tmp = 0
        for j in range(n):
            if arr[i][j] == 1:
                tmp += 1
            if arr[i][j] == 0 or j == n-1:
                if tmp == k:
                    answer += 1
                tmp = 0
    for j in range(n):
        tmp = 0
        for i in range(n):
            if arr[i][j] == 1:
                tmp += 1
            if arr[i][j] == 0 or i == n-1:
                if tmp == k:
                    answer += 1
                tmp = 0
    print(f"#{test_case} {answer}")
