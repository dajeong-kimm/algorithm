n,m = map(int,input().split())
true_know = list(map(int,input().split()))
party = []
for _ in range(m):
    tmp = list(map(int,input().split()))
    tmp.pop(0)
    party.append(set(tmp))

if true_know[0] == 0:
    print(len(party))
    exit()

true_set = set(true_know[1:])
answer = 0

for _ in range(m):
    for p in party:
        if p & true_set:
            true_set = true_set.union(p)

for i in range(len(party)):
    if party[i].isdisjoint(true_set):
        answer += 1



print(answer)
    