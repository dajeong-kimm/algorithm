n = int(input())
score = 0
bonus = 0
prob = list(map(int, input().split()))

for p in prob:
    if p == 1:
        bonus += 1
        score += bonus
    else:
        bonus = 0
print(score)