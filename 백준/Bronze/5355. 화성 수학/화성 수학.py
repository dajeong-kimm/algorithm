n = int(input())

for _ in range(n):
    number = list(map(str, input().split()))
    num = float(number[0])
    for i in range(1,len(number)):
        if number[i] == "@":
            num *= 3
        elif number[i] == "%":
            num += 5
        elif number[i] == "#":
            num -= 7
    print("{:.2f}".format(num))