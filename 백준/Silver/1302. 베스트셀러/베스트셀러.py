n = int(input())

dict = {}

for _ in range(n):
    tmp = input()
    if tmp not in dict:
        dict[tmp] = 0
    dict[tmp] += 1

arr = list(dict.items())
arr.sort(key = lambda x:(-x[1],x[0]))

print(arr[0][0])