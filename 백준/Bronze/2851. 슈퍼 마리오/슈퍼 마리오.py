
score = 0
total = []
for _ in range(10):
    tmp = int(input())
    score += tmp
    total.append(score)
result = False
for i in range(9):
    if abs(total[i]-100)<abs(total[i+1]-100):
        print(total[i])
        result = True
        break
    elif abs(total[i]-100)==abs(total[i+1]-100):
        print(total[i+1])
        result = True
        break

if not result:
    print(total[-1])
