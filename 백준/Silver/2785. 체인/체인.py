n = int(input())
chain = list(map(int,input().split()))
count = 0
chain.sort()
use_chain = 0

for c in chain:
    if c==n-1:
        answer = use_chain+c
    elif c>n-1:
        answer = use_chain+n-1
    else:
        n -= (c+1)
        use_chain += c

print(answer)