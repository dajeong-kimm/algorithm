n = int(input())
dict = {}
for _ in range(n):
    a,b = map(str,input().split('.'))
    if b not in dict:
        dict[b] = 0
    dict[b] += 1

sorted_dict = sorted(dict.items(),key=lambda x:x[0])

for a,b in sorted_dict:
    print(a,b)