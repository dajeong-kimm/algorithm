from collections import deque
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    arr.sort()

    answer = 0
    answer = max(abs(arr[-1]-arr[-2]),abs(arr[-1]-arr[-3]))

    for i in range(n-2,1,-1):
        answer = max(answer,abs(arr[i]-arr[i-2]))
    
    answer = max(answer,abs(arr[0]-arr[1]))

    print(answer)