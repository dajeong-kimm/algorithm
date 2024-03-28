n, k = map(int,input().split())

num = list(map(int,input().split()))

result = []
result.append(sum(num[:k]))

for i in range(n-k):
    result.append(result[i]-num[i]+num[i+k])

print(max(result))