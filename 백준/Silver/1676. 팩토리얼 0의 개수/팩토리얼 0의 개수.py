def facto(n):
    fact = [i for i in range(501)]
    fact[0] = 1
    for i in range(3,n+1):
        fact[i] = i*fact[i-1]
    return fact[n]

num = int(input())
answer = 0
f = list(str(facto(num)))

while f:
    if f[-1]=='0':
        answer += 1
        f.pop()
    else:
        break

print(answer)