n = int(input())

for _ in range(n):
    tmp = input().split()
    new_list = []
    for t in tmp:
        new_list.append(t[::-1])
    print(' '.join(new_list))