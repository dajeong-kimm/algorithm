# print(ord('a')) 97

l = int(input())
s = list(input())

answer = 0
for i in range(l):
    answer += (ord(s[i])-96)*31**i%1234567891

print(answer)