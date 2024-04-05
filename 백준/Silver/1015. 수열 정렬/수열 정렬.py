n = int(input())

arr = list(map(int,input().split()))

sorted_arr = sorted(arr)

p = []
for i in range(n):
    p.append(sorted_arr.index(arr[i]))
    sorted_arr[sorted_arr.index(arr[i])] = -1

print(*p)

