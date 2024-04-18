word = list(input())
arr = ['a','e','i','o','u']

answer = 0
for w in word:
    if w in arr:
        answer += 1
print(answer)