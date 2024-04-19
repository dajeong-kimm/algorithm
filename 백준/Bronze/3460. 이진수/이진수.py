t = int(input())
for _ in range(t):
    n = int(input())
    answer = []
    binary = list(bin(n)[2:][::-1])
    for i in range(len(binary)):
        if binary[i] == "1":
            answer.append(i)
    print(*answer)