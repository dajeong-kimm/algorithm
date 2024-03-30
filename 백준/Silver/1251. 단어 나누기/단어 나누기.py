from itertools import combinations
s = list(input())

n = len(s)
num = [i for i in range(n)]
dict = []
for a,b,c in combinations(num,3):
    tmp = s[0:b][::-1]+s[b:c][::-1]+s[c:][::-1]
    dict.append(tmp)
dict.sort()
print(''.join(dict[0]))

# s = 'dajeong'
# tmp = s[:3][::-1]
# print(tmp)