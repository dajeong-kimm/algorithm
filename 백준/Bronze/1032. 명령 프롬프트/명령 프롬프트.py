n = int(input())
answer = []
for _ in range(n):
    tmp = list(input())
    if not answer:
        answer = tmp
    else:
        for i in range(len(answer)):
            if answer[i] != tmp[i]:
                answer[i] = '?'

print(''.join(answer))