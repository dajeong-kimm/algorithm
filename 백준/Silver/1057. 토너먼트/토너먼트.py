import math
n,a,b = map(int,input().split())
round = 0
while a!=b:
    a = math.ceil(a/2)
    b = math.ceil(b/2)
    round += 1

print(round)