t = int(input())

for test_case in range(1,t+1):
    n,m,k = map(int,input().split())
    arr = list(map(int,input().split()))
    arr.sort()
    cur = 0
    time = 1
    answer = "Possible"
    for i in range(n):
        for t in range(time,arr[i]+1):
            if t%m == 0:
                cur += k
            time += 1
        if cur<1:
            answer = "Impossible"
            break
        else:
            cur -= 1
    print(f"#{test_case} {answer}")