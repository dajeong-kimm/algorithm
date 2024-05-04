t = int(input())
for i in range(t):
    print(f"Class {i+1}")
    arr = list(map(int,input().split()))
    score = arr[1:]
    score.sort()
    largest_gap = 0
    for i in range(len(score)-1):
        largest_gap = max(largest_gap,score[i+1]-score[i])
    print(f"Max {score[-1]}, Min {score[0]}, Largest gap {largest_gap}")