n,m = map(int,input().split())
arr = []
for _ in range(n):
    arr.append(list(input()))

answer = []
for i in range(m):
    dict = {}
    for j in range(n):
        if arr[j][i] not in dict:
            dict[arr[j][i]] = 0
        dict[arr[j][i]] += 1
    sorted_dict = sorted(dict.items(), key = lambda x:(-x[1],x[0]))
    answer.append(sorted_dict[0][0])

count = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] != answer[j]:
            count += 1
print(''.join(answer))
print(count)   