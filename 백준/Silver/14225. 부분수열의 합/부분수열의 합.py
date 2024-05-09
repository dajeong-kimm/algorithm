from itertools import combinations
n = int(input())
arr = list(map(int,input().split()))

min_value = min(arr)
if min_value>1:
    print(1)
    exit()
sum_value = sum(arr)
make = [False for _ in range(sum_value+1)]
for i in range(1,len(arr)+1):
    for com in combinations(arr,i):
        tmp = sum(com)
        make[tmp] = True

for i in range(2,sum_value):
    if make[i] == False:
        print(i)
        exit()
print(sum_value+1)
