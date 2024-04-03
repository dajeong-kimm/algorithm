t = int(input())



for _ in range(t):
    n = int(input())
    dict = {}
    for _ in range(n):
        a,b = map(str,input().split())
        if b not in dict:
            dict[b] = 1
        else:
            dict[b] += 1
    answer = 1
    for d in dict:
        answer *= (dict[d]+1)
    print(answer-1)
    

        