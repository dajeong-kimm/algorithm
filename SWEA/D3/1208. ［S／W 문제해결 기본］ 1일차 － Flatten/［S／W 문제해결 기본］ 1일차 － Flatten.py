import heapq

for test in range(1,11):
    n = int(input())
    arr = list(map(int,input().split()))
    cnt = 0
    while cnt<n:
        cnt += 1
        min_value = min(arr)
        max_value = max(arr)
        if max_value-min_value <2:
            answer = max_value-min_value
            break
        arr[arr.index(min_value)] += 1
        arr[arr.index(max_value)] -= 1
    answer = max(arr)-min(arr)
    print(f"#{test} {answer}")
