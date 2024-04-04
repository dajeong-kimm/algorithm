import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

dict = {}
for a in arr:
    if a not in dict:
        dict[a] = 0
    dict[a] += 1

result = list(dict.items())
result = sorted(result,key=lambda x:(-x[1],x[0]))

print(result[0][0])