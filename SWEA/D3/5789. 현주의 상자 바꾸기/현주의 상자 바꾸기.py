t = int(input())

for test_case in range(1,t+1):
    N,Q = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(Q)]
    box = [0 for _ in range(N)]
    for i in range(Q):
        l,r = arr[i]
        for j in range(l-1,r):
            box[j] = i+1

    print(f"#{test_case}",end=" ")
    print(*box)