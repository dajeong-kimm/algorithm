def dif_count(a,b):
    answer = 0
    for i in range(4):
        if a[i] != b[i]:
            answer += 1
    return answer

# mbti = ['ENTJ','INTP','ESFJ']
# print(dif_count(mbti[0],mbti[1]))

t = int(input())
for _ in range(t):
    n = int(input())
    mbti = list(input().split())
    if n>32:
        print(0)
        continue
    result = int(1e9)
    for i in range(n-2):
        for j in range(i+1,n-1):
            for k in range(j+1,n):
                tmp = dif_count(mbti[i],mbti[j])+dif_count(mbti[j],mbti[k])+dif_count(mbti[k],mbti[i])
                result = min(result,tmp)
    print(result)