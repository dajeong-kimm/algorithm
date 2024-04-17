# print(ord('A')) 65

s = list(input())

idx = 0
answer = 0
while s:
    tmp = s.pop()
    if tmp.isalpha():
        num = ord(tmp)-55
    else:
        num = int(tmp)
    answer += (num*16**idx)
    idx += 1

print(answer)
    