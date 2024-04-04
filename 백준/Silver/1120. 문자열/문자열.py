a,b = map(str,input().split())
a = list(a)
b = list(b)

a_len = len(a)
b_len = len(b)

answer = 0
result = []
if a_len==b_len:
    for i in range(a_len):
        if a[i]!=b[i]:
            answer += 1
    print(answer)
else:
    for i in range(b_len-a_len+1):
        count = 0
        for j in range(a_len):
            if a[j] != b[i+j]:
                count += 1
        result.append(count)
    print(min(result))