t = int(input())
for test_case in range(1,t+1):
    n = int(input())
    arr = list(map(str,input().split()))
    answer = []
    if n%2==0:
        arr2 = arr[n//2:]
    else:
        arr2 = arr[n//2+1:]
    idx = 0
    for i in range(n):
        if i%2==0:
            answer.append(arr[idx])
        else:
            answer.append(arr2[idx])
            idx += 1
    print(f"#{test_case}",end=" ")
    print(*answer)