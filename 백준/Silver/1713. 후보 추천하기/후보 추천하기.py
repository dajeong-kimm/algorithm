n = int(input())
m = int(input())
arr = list(map(int,input().split()))

dict = {}

idx = 1
for a in arr:
    if a not in dict:
        if len(dict)<n:
            dict[a] = [1,idx]
            idx += 1
        else:
            tmp = sorted(dict.items(),key=lambda x:(x[1]))[0]
            del dict[tmp[0]]
            dict[a] = [1,idx]
            idx += 1
    else:
        dict[a][0] += 1

answer = []
for d in dict.items():
    answer.append(d[0])

answer.sort()
print(*answer)




            

