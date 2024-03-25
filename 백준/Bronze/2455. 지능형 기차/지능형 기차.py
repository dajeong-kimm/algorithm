num = []
people = 0
for _ in range(4):
    out, inp = map(int,input().split())
    people -= out
    num.append(people)
    people += inp
    num.append(people)
print(max(num))