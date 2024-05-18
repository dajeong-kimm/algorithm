t = int(input())

for _ in range(t):
    n,s = map(str,input().split())
    s_list = list(s)
    n = int(n)
    s_list.pop(n-1)
    print(''.join(s_list))