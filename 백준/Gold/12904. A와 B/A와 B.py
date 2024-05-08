s = list(input())
t = list(input())

answer = 0
while len(t)>=len(s):
    if t[-1] == "A":
        t.pop()
    elif t[-1] == "B":
        t.pop()
        t.reverse()
    
    if t == s:
        answer = 1
        break

print(answer)
