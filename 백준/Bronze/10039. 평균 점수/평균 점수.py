total_score = 0
score = []
for _ in range(5):
    score.append(int(input()))

for s in score:
    if s < 40 :
        total_score += 40
    else:
        total_score += s
print(total_score//5)