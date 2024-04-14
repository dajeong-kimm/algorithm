n,d,k,c = map(int,input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

arr = arr*2
answer = 0
for i in range(n):
    new_arr = arr[i:i+k]
    new_set = set(new_arr)
    tmp = len(new_set)
    if c not in new_set:
        tmp += 1
    answer = max(answer,tmp)
    if tmp == k+1:
        break

print(answer)
