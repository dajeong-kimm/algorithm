from itertools import combinations
l,c = map(int,input().split())
arr = list(map(str,input().split()))
a = ['a','e','i','o','u']
b = ['b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z']

answer = []
for per in combinations(arr,l):
    tmp = per.count('a')+per.count('e')+per.count('i')+per.count('o')+per.count('u')
    if tmp<1:
        continue
    else:
        cnt = 0
        for p in per:
            if p in b:
                cnt += 1
        if cnt>=2:
            answer.append(sorted(''.join(per)))

answer.sort()
for ans in answer:
    print(''.join(ans))

