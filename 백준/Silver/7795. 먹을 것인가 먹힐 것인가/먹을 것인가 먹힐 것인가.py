t = int(input())

for _ in range(t):
    n,m = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    A.sort(reverse=True)
    B.sort(reverse=True)
    answer=0
    for i in range(n):
        cnt = m
        for j in range(m):
            if A[i]>B[j]:
                break
            else:
                cnt -=1
        answer += cnt
        if cnt == 0:
            break
    print(answer)
