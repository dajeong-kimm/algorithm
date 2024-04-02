t = int(input())

for _ in range(t):
    n, m = map(int,input().split())
    answer = 0
    for i in range(n,m+1):
        tmp = list(str(i))
        answer += tmp.count('0')
    
    print(answer)