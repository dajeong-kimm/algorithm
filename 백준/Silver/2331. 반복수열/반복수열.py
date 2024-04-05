a,p = map(int,input().split())
d = [a]
idx = 0
while True:
    tmp = list(str(d[idx]))
    num = 0
    for t in tmp:
        num += int(t)**p
    if num not in d:
        d.append(num)
        idx += 1
    else:
        index = d.index(num)
        print(index)
        break
        