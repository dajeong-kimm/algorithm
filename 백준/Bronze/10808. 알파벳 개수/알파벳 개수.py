# print(ord('a')) 97 
# print(ord('z')) 122

alpha = [0]*26

s = list(input())

for i in s:
    tmp = ord(i)-97
    alpha[tmp] += 1

print(*alpha)