n = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

answer = 0
for i in range(n-1,0,-1):
    if arr[i]<=arr[i-1]:
        answer += (arr[i-1]-arr[i]+1)
        arr[i-1] = arr[i]-1

print(answer)