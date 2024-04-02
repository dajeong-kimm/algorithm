import math
num = list(input())
answer = 0
for i in range(len(num)-1):
    if num[i] != num[i+1]:
        answer += 1

print(math.ceil(answer/2))