t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    arr = list(map(int,input().split()))
    max_value = arr[-1]
    answer = 0
    for i in range(n-2,-1,-1):
        if arr[i]<max_value:
            answer += max_value-arr[i]
        else:
            max_value = arr[i]
    print(f"#{test_case} {answer}")