n,p = map(int,input().split())
melody = [list(map(int,input().split())) for _ in range(n)]

play = [[] for _ in range(7)]
answer = 0
for a,b in melody:
    if play[a]:
        if play[a][-1]>b:
            while play[a]:
                tmp = play[a].pop()
                if tmp<=b:
                    play[a].append(tmp)
                    break
                answer += 1
        if play[a] and play[a][-1]==b:
            continue
    play[a].append(b)
    answer += 1

print(answer)