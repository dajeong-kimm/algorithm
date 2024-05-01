a = input()

answer = ""
for i in range(len(a)):
    tmp = ord(a[i])
    if tmp-ord('A')-3<0:
        tmp += 26
    tmp -= 3
    answer += chr(tmp)

print(answer)
