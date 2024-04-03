n = int(input())
arr = list(map(int,input().split()))

a = 0
re = []

for i in range(n-1):
    if arr[i]<arr[i+1]:
        a += arr[i+1]-arr[i]
    else:
        re.append(a)
        a = 0

re.append(a)
print(max(re))