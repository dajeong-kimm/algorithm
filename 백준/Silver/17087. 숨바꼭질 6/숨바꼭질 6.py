import sys

def gcd(a,b):
    if a<b:
        a,b = b,a
    while b>0:
        a,b = b,a%b
    return a

n,s = map(int,input().split())

arr = list(map(int,input().split()))

answer = []
for a in arr:
    if a!=s:
        answer.append(abs(a-s))

if len(answer)==1:
    print(answer[0])
    exit()

result = gcd(answer[0],answer[1])

for i in range(2,len(answer)):
    result = gcd(result,answer[i])

print(result)