arr = list(map(int,input().split()))
arr.sort()
dict = {"A":arr[0],"B":arr[1],"C":arr[2]}
s = input()
answer = []
for i in s:
    answer.append(dict[i])
print(*answer)