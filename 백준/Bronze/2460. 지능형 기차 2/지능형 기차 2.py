answer = 0
result = []
for _ in range(10):
    a,b = map(int,input().split())
    answer -= a
    answer += b
    result.append(answer)

print(max(result))
