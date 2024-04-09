from itertools import combinations
while True:
    arr = list(map(int,input().split()))
    k = arr[0]
    if k == 0:
        exit()
    sorted_arr = sorted(arr[1:])
    for com in combinations(sorted_arr,6):
        print(*com)
    print()
