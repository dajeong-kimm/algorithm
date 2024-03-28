import sys
input = sys.stdin.readline

n,m = map(int,input().split())
num = list(map(int,input().split()))
s = []

number = 0
for nu in num:
    number += nu
    s.append(number)

for _ in range(m):
    #i-1부터 j-1까지
    i,j = map(int,input().split())
    if i>1:

        answer = s[j-1]-s[i-2]
    else:
        answer = s[j-1]
    
    print(answer)
