a = ['a','e','i','o','u']

while True:
    s = list(input())
    if s[0] == "#":
        break
    answer = 0
    for i in s:
        if i.lower() in a:
            answer += 1
    print(answer)
