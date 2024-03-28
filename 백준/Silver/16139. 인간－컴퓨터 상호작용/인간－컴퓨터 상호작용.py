import sys
input = sys.stdin.readline

# print(ord('a'))
s = input().strip()
count = [[0]*26]

q = int(input())

for i, ch in enumerate(s):
    count.append(count[len(count)-1][:])
    count[i+1][ord(ch)-97] += 1

for _ in range(q):
    alpha, l, r = input().split()
    answer = count[int(r)+1][ord(alpha)-97] - count[int(l)][ord(alpha)-97]

    print(answer)