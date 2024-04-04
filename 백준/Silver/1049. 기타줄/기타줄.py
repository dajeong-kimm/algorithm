n,m = map(int,input().split())

answer = 1000*100
six = []
one = []
for _ in range(m):
    a,b = map(int,input().split())
    six.append(a)
    one.append(b)

one_min = min(one)
answer = min(answer,n*one_min)

six_min = min(six)
answer = min(answer,(n//6)*six_min+(n%6)*one_min)

answer = min(answer,(n//6+1)*six_min)
print(answer)
