n,m = map(int,input().split())
for _ in range(n):
    tmp = list(input())
    tmp.reverse()
    print(''.join(tmp))