from collections import Counter

n,c = map(int,input().split())
arr = list(map(int,input().split()))
counter_arr = dict(Counter(arr))
counter_arr = sorted(counter_arr.items(),key=lambda x:x[1],reverse=True)
# print(counter_arr)
answer = []
for a,b in counter_arr:
    for i in range(b):
        answer.append(a)

print(*answer)
