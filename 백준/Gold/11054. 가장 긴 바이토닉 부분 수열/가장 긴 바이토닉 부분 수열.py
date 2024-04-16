n = int(input())
arr = list(map(int,input().split()))

reverse_arr = arr[::-1]

increase = [1 for i in range(n)]
decrease = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i]>arr[j]:
            increase[i] = max(increase[i],increase[j]+1)
        if reverse_arr[i]>reverse_arr[j]:
            decrease[i] = max(decrease[i],decrease[j]+1)

result = [0 for i in range(n)]
for i in range(n):
    result[i] = increase[i]+decrease[n-i-1]-1

print(max(result))