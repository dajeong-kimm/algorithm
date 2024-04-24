cambridge = set(['C','A','M','B','R','I','D','G','E'])

s = list(input())
answer = ""
for i in s:
    if i not in cambridge:
        answer += i
print(answer)