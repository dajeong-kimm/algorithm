a,b = map(str,input().split())
a = list(a)
b = list(b)
rev_a = int(''.join(a[::-1]))
rev_b = int(''.join(b[::-1]))

answer = str((rev_a+rev_b))
print(int(answer[::-1]))


