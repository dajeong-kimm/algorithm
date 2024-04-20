a,b = map(int,input().split())
c,d = map(int,input().split())

answer = min(a+d,b+c)
print(answer)