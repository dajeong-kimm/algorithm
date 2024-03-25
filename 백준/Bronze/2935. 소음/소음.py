a = str(input())
op = str(input())
b = str(input())
if op == '*':
    answer = ['1']
    for _ in range(len(a)-1):
        answer.append('0')
    for _ in range(len(b)-1):
        answer.append('0')
    print(int(''.join(answer)))

else:
    print(int(a)+int(b))
    