t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    bus = [list(map(int,input().split())) for _ in range(n)]
    p = int(input())
    p_list = [int(input()) for _ in range(p)]

    answer = []
    dict = {}
    for a,b in bus:
        for i in range(a,b+1):
            if i not in dict:
                dict[i] = 0
            dict[i] += 1

    for p in p_list:
        if p not in dict:
            answer.append(0)
        else:
            answer.append(dict[p])
    print(f"#{test_case}",end= " ")
    print(*answer)
