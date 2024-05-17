t = int(input())

for test_case in range(1,t+1):
    arr = list(map(int,input().split()))
    answer = 0
    for a in arr:
        if a%2 == 1:
            answer += a
    print(f"#{test_case} {answer}")