import sys
input = sys.stdin.readline

n = int(input())
size = 1
while n>size:
    size *= 2

answer = 0
new_size = size
while n>0:
    if new_size<=n:
        n -= new_size
    else:
        new_size = new_size//2
        answer += 1

print(size, answer)