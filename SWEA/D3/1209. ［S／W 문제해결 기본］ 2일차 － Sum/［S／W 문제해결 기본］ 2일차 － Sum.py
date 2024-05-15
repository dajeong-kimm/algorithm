import heapq

for _ in range(10):
    test_case = int(input())
    arr = [list(map(int,input().split())) for _ in range(100)]
    answer = 0
    for a in arr:
        answer = max(answer,sum(a))

    for i in range(100):
        tmp = 0
        for j in range(100):
            tmp += arr[j][i]
        answer = max(answer,tmp)

    tmp = 0
    for i in range(100):
        tmp += arr[i][i]
    answer = max(answer,tmp)
    tmp = 0
    for i in range(100):
        tmp += arr[i][99-i]
    answer = max(answer,tmp)
    print(f"#{test_case} {answer}")
