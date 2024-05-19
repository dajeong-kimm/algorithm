t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    arr = list(map(int,input().split()))
    avg = sum(arr)/n
    answer = 0
    for a in arr:
        if a<=avg:
            answer += 1
    print(f"#{test_case} {answer}")