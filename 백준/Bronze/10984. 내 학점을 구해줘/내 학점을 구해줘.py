n = int(input())

for _ in range(n):
    m = int(input())
    total = 0
    grade = 0.0
    for _ in range(m):
        a, b = map(float, input().split())
        total += a
        grade += (a*b)
    print(int(total))
    average = grade/total
    print('{:.2f}'.format(average))